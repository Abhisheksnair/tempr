package com.whatsapp;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import android.os.Build.VERSION;
import com.whatsapp.k.c;
import com.whatsapp.k.d;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

@TargetApi(16)
public final class ah
  implements xf
{
  private static final int[] j = { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000 };
  final File a;
  final long b;
  final long c;
  final File d;
  xf.a e;
  boolean f;
  private final int g;
  private ByteBuffer[] h;
  private int i;
  
  private ah(a parama)
  {
    this.a = parama.a;
    this.b = parama.b;
    this.c = parama.c;
    this.d = parama.d;
    this.g = parama.e;
  }
  
  private static void a(int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    paramArrayOfByte[0] = -1;
    paramArrayOfByte[1] = -15;
    int k = 0;
    if (k < j.length) {
      if (paramInt1 != j[k]) {}
    }
    for (;;)
    {
      paramInt1 = (byte)k;
      paramInt2 = (byte)paramInt2;
      paramArrayOfByte[2] = 64;
      paramArrayOfByte[2] = ((byte)(paramInt1 << 2 | paramArrayOfByte[2]));
      paramArrayOfByte[2] = ((byte)(paramArrayOfByte[2] | paramInt2 >> 2));
      paramArrayOfByte[3] = ((byte)((paramInt2 & 0x3) << 6));
      paramArrayOfByte[4] = 0;
      paramArrayOfByte[5] = 0;
      paramArrayOfByte[6] = -4;
      return;
      k += 1;
      break;
      Log.e("audiotranscoder/sampling rate " + paramInt1 + " bps is not supported");
      k = 0;
    }
  }
  
  private void a(MediaCodec paramMediaCodec, MediaCodec.BufferInfo paramBufferInfo, byte[] paramArrayOfByte, WritableByteChannel paramWritableByteChannel)
  {
    int k = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 0L);
    if (k != -1)
    {
      Object localObject;
      if (k >= 0)
      {
        localObject = this.h[k];
        ((ByteBuffer)localObject).position(paramBufferInfo.offset);
        ((ByteBuffer)localObject).limit(paramBufferInfo.offset + paramBufferInfo.size);
        if ((paramBufferInfo.flags & 0x2) == 0)
        {
          this.i += 1;
          int m = paramBufferInfo.size - paramBufferInfo.offset + 7;
          paramArrayOfByte[3] = ((byte)(m >> 11 & 0x3 | paramArrayOfByte[3] & 0xFC));
          paramArrayOfByte[4] = ((byte)(m >> 3 & 0xFF));
          paramArrayOfByte[5] = ((byte)((m & 0x7) << 5 | 0x1F));
          paramWritableByteChannel.write(ByteBuffer.wrap(paramArrayOfByte));
          paramWritableByteChannel.write((ByteBuffer)localObject);
        }
        ((ByteBuffer)localObject).clear();
        paramMediaCodec.releaseOutputBuffer(k, false);
      }
      for (;;)
      {
        k = paramMediaCodec.dequeueOutputBuffer(paramBufferInfo, 0L);
        break;
        if (k == -3)
        {
          this.h = paramMediaCodec.getOutputBuffers();
          Log.i("audiotranscoder/encoder output buffers have changed");
        }
        else if (k == -2)
        {
          localObject = paramMediaCodec.getOutputFormat();
          Log.i("audiotranscoder/encoder output format has changed to " + localObject);
        }
      }
    }
  }
  
  public static boolean a(File paramFile)
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT < 16) {}
    while ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    try
    {
      localMediaMetadataRetriever.setDataSource(paramFile.getAbsolutePath());
      paramFile = localMediaMetadataRetriever.extractMetadata(16);
      if (paramFile != null) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramFile)
    {
      Log.d("audiotranscoder/cantranscode", paramFile);
      return false;
    }
    finally
    {
      localMediaMetadataRetriever.release();
    }
  }
  
  public final void a()
  {
    d locald = c.b("VideoTranscoder_transcodeAudio");
    locald.a();
    Log.i("audiotranscoder/bitrate:" + this.g);
    MediaExtractor localMediaExtractor = new MediaExtractor();
    localMediaExtractor.setDataSource(this.a.getAbsolutePath());
    int m = localMediaExtractor.getTrackCount();
    Log.i("audiotranscoder/Number of tracks:" + m);
    int k = 0;
    Object localObject7;
    FileOutputStream localFileOutputStream;
    FileChannel localFileChannel;
    int i2;
    Object localObject8;
    int i1;
    int n;
    label309:
    long l1;
    MediaCodec localMediaCodec1;
    MediaCodec localMediaCodec2;
    ByteBuffer[] arrayOfByteBuffer;
    MediaCodec.BufferInfo localBufferInfo1;
    MediaCodec.BufferInfo localBufferInfo2;
    byte[] arrayOfByte;
    Object localObject2;
    for (;;)
    {
      if (k < m)
      {
        Object localObject1 = localMediaExtractor.getTrackFormat(k);
        localObject7 = ((MediaFormat)localObject1).getString("mime");
        Log.i("audiotranscoder/track:" + k + "mime:" + (String)localObject7 + " format:" + localObject1);
        if (((String)localObject7).startsWith("audio"))
        {
          if (k < 0)
          {
            Log.w("audiotranscoder/no audio tracks");
            localMediaExtractor.release();
          }
        }
        else
        {
          k += 1;
          continue;
        }
        localFileOutputStream = new FileOutputStream(this.d);
        localFileChannel = localFileOutputStream.getChannel();
        i2 = MediaCodecList.getCodecCount();
        localObject1 = null;
        Log.i("audiotranscoder/number of codecs: " + i2);
        m = 0;
        while ((m < i2) && (localObject1 == null))
        {
          localObject7 = MediaCodecList.getCodecInfoAt(m);
          if (!((MediaCodecInfo)localObject7).isEncoder()) {
            break label1829;
          }
          localObject8 = ((MediaCodecInfo)localObject7).getSupportedTypes();
          i1 = 0;
          n = 0;
          while ((n < localObject8.length) && (i1 == 0))
          {
            if (localObject8[n].equals("audio/mp4a-latm")) {
              i1 = 1;
            }
            n += 1;
          }
          if (i1 == 0) {
            break label1829;
          }
          localObject1 = localObject7;
          m += 1;
        }
        if (localObject1 == null)
        {
          Log.i("audiotranscoder/ no codec supporting audio/mp4a-latm");
          localMediaExtractor.release();
          throw new FileNotFoundException("No codec supporting audio/mp4a-latm");
        }
        Log.i("audiotranscoder/found " + ((MediaCodecInfo)localObject1).getName() + " supporting audio/mp4a-latm");
        localObject7 = localMediaExtractor.getTrackFormat(k);
        localObject8 = ((MediaFormat)localObject7).getString("mime");
        localMediaExtractor.selectTrack(k);
        if (((MediaFormat)localObject7).containsKey("durationUs")) {}
        for (l1 = ((MediaFormat)localObject7).getLong("durationUs");; l1 = 0L)
        {
          Log.i("audiotranscoder/decoder format:" + ((MediaFormat)localObject7).toString());
          this.h = null;
          this.i = 0;
          try
          {
            localMediaCodec1 = MediaCodec.createDecoderByType((String)localObject8);
            Log.i("audiotranscoder/decoder created");
            if (localMediaCodec1 != null) {
              break;
            }
            Log.e("audiotranscoder/can't create decoder for " + (String)localObject8);
            localMediaExtractor.release();
            throw new MediaFileUtils.a();
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            Log.e("audiotranscoder/can't create decoder for " + (String)localObject8 + " " + localIllegalArgumentException);
            localMediaExtractor.release();
            throw new MediaFileUtils.a();
          }
        }
        localMediaCodec2 = MediaCodec.createByCodecName(localIllegalArgumentException.getName());
        Log.i("audiotranscoder/encoder created");
        localMediaCodec1.configure((MediaFormat)localObject7, null, null, 0);
        Log.i("audiotranscoder/decoder configured");
        localMediaCodec1.start();
        Log.i("audiotranscoder/decoder started");
        arrayOfByteBuffer = localMediaCodec1.getInputBuffers();
        localObject8 = localMediaCodec1.getOutputBuffers();
        localBufferInfo1 = new MediaCodec.BufferInfo();
        localBufferInfo2 = new MediaCodec.BufferInfo();
        if (this.b > 0L)
        {
          localMediaExtractor.seekTo(this.b * 1000L, 0);
          Log.i("audiotranscoder/seek to:" + this.b * 1000L + " actual:" + localMediaExtractor.getSampleTime());
        }
        arrayOfByte = new byte[7];
        k = 0;
        i1 = 0;
        m = 0;
        n = 0;
        localObject2 = null;
        if (m != 0) {
          break;
        }
      }
    }
    for (;;)
    {
      try
      {
        if (!this.f)
        {
          i2 = localMediaCodec1.dequeueInputBuffer(0L);
          int i4;
          if (i2 >= 0)
          {
            i3 = localMediaExtractor.readSampleData(arrayOfByteBuffer[i2], 0);
            if (i3 < 0)
            {
              Log.i("audiotranscoder/extractor BUFFER_FLAG_END_OF_STREAM");
              localMediaCodec1.queueInputBuffer(i2, 0, 0, 0L, 4);
              m = 1;
              i5 = localMediaCodec1.dequeueOutputBuffer(localBufferInfo1, 1000000L);
              if (i5 < 0) {
                continue;
              }
              if (localBufferInfo1.presentationTimeUs < this.b * 1000L) {
                continue;
              }
              if (k != 0) {
                continue;
              }
              i3 = ((MediaFormat)localObject7).getInteger("sample-rate");
              i4 = ((MediaFormat)localObject7).getInteger("channel-count");
              if (((MediaFormat)localObject7).containsKey("pcm-encoding"))
              {
                i2 = ((MediaFormat)localObject7).getInteger("pcm-encoding");
                int i6 = this.g;
                localObject2 = MediaFormat.createAudioFormat("audio/mp4a-latm", i3, i4);
                ((MediaFormat)localObject2).setInteger("bitrate", i6);
                ((MediaFormat)localObject2).setInteger("sample-rate", i3);
                ((MediaFormat)localObject2).setInteger("channel-count", i4);
                ((MediaFormat)localObject2).setInteger("aac-profile", 2);
                ((MediaFormat)localObject2).setInteger("max-input-size", 64000);
                if (i2 != 0) {
                  ((MediaFormat)localObject2).setInteger("pcm-encoding", i2);
                }
                Log.i("audiotranscoder/configuring encoder with output format " + localObject2);
                localMediaCodec2.configure((MediaFormat)localObject2, null, null, 1);
                Log.i("audiotranscoder/encoder configured");
                a(((MediaFormat)localObject7).getInteger("sample-rate"), ((MediaFormat)localObject7).getInteger("channel-count"), arrayOfByte);
                localMediaCodec2.start();
                localObject2 = localMediaCodec2.getInputBuffers();
                this.h = localMediaCodec2.getOutputBuffers();
                k = 1;
                try
                {
                  i4 = localMediaCodec2.dequeueInputBuffer(1000000L);
                  if (i4 != -1) {
                    continue;
                  }
                  a(localMediaCodec2, localBufferInfo2, arrayOfByte, localFileChannel);
                  continue;
                  localMediaCodec1.stop();
                }
                finally
                {
                  i1 = k;
                }
                localMediaCodec1.release();
                if (i1 != 0) {
                  localMediaCodec2.stop();
                }
                localMediaCodec2.release();
                localMediaExtractor.release();
                throw ((Throwable)localObject3);
              }
            }
            else
            {
              localMediaCodec1.queueInputBuffer(i2, 0, i3, localMediaExtractor.getSampleTime(), 0);
              localMediaExtractor.advance();
            }
          }
          else
          {
            continue;
          }
          i2 = 0;
          continue;
          i2 = m;
          int i3 = n;
          if (i4 >= 0)
          {
            localObject9 = localObject3[i4];
            ByteBuffer localByteBuffer = localObject8[i5];
            localByteBuffer.position(localBufferInfo1.offset);
            localByteBuffer.limit(localBufferInfo1.offset + localBufferInfo1.size);
            ((ByteBuffer)localObject9).clear();
            ((ByteBuffer)localObject9).put(localByteBuffer);
            localMediaCodec2.queueInputBuffer(i4, 0, localBufferInfo1.size, localBufferInfo1.presentationTimeUs, localBufferInfo1.flags);
            localByteBuffer.position(localBufferInfo1.offset);
            localByteBuffer.limit(localBufferInfo1.offset + localBufferInfo1.size);
            i4 = m;
            if (this.c > 0L)
            {
              i4 = m;
              if (localBufferInfo1.presentationTimeUs > this.c * 1000L) {
                i4 = 1;
              }
            }
            i2 = i4;
            i3 = n;
            if (l1 != 0L)
            {
              i2 = i4;
              i3 = n;
              if (this.e != null)
              {
                if (this.b > 0L) {
                  continue;
                }
                l2 = 0L;
                if (this.c > 0L) {
                  continue;
                }
                l3 = l1;
                m = (int)(100L * (localBufferInfo1.presentationTimeUs - l2) / (l3 - l2));
                i2 = i4;
                i3 = n;
                if (m != n)
                {
                  if (this.f) {
                    break label1837;
                  }
                  if (!this.e.a(m)) {
                    continue;
                  }
                  break label1837;
                  this.f = bool;
                  i3 = m;
                  i2 = i4;
                }
              }
            }
          }
          a(localMediaCodec2, localBufferInfo2, arrayOfByte, localFileChannel);
          n = i3;
          m = i1;
          i1 = k;
        }
      }
      finally
      {
        try
        {
          int i5;
          long l2;
          long l3;
          localMediaCodec1.releaseOutputBuffer(i5, false);
          i1 = i2;
          Object localObject9 = localObject8;
          localObject8 = localObject3;
          Object localObject4 = localObject9;
          i2 = n;
          n = i1;
          i1 = k;
          if ((localBufferInfo1.flags & 0x4) != 0)
          {
            i1 = k;
            Log.i("audiotranscoder/decoder OutputBuffer BUFFER_FLAG_END_OF_STREAM");
            i1 = k;
            Log.i("audiotranscoder/processed frames:" + this.i + " skipped:" + m);
            localMediaCodec1.stop();
            localMediaCodec1.release();
            if (k != 0) {
              localMediaCodec2.stop();
            }
            localMediaCodec2.release();
            localMediaExtractor.release();
          }
          try
          {
            localFileChannel.close();
            localFileOutputStream.close();
            locald.b();
            Log.i("audiotranscoder finished: " + locald.e() + " cancelled:" + this.f + " output:" + this.d.length());
            return;
            l2 = this.b * 1000L;
            continue;
            l3 = this.c;
            l3 *= 1000L;
            continue;
            bool = false;
            continue;
            i1 += 1;
            i2 = m;
            m = i1;
            continue;
            if (i5 == -3)
            {
              localObject8 = localMediaCodec1.getOutputBuffers();
              Log.i("audiotranscoder/decoder output buffers have changed.");
              i2 = m;
              m = i1;
              i1 = n;
              localObject9 = localObject4;
              n = i2;
              i2 = i1;
              localObject4 = localObject8;
              localObject8 = localObject9;
              continue;
            }
            if (i5 == -2)
            {
              localObject7 = localMediaCodec1.getOutputFormat();
              Log.i("audiotranscoder/decoder output format has changed to " + localObject7);
            }
            i2 = m;
            m = i1;
            i1 = n;
            localObject9 = localObject4;
            n = i2;
            i2 = i1;
            localObject4 = localObject8;
            localObject8 = localObject9;
            continue;
            i1 = m;
            localObject9 = localObject8;
            m = n;
            n = i2;
            localObject8 = localObject4;
            localObject4 = localObject9;
          }
          catch (IOException localIOException)
          {
            Log.d("audiotranscoder/close", localIOException);
            continue;
          }
          localObject5 = finally;
          i1 = k;
          continue;
        }
        finally {}
        continue;
        continue;
      }
      m = i1;
      continue;
      label1829:
      break label309;
      k = -1;
      break;
      label1837:
      boolean bool = true;
    }
  }
  
  public final void b()
  {
    this.f = true;
  }
  
  public final boolean c()
  {
    return true;
  }
  
  public static final class a
  {
    File a;
    long b;
    long c;
    File d;
    int e = 96000;
    
    public a(File paramFile1, File paramFile2)
    {
      this.a = paramFile1;
      this.d = paramFile2;
    }
    
    public final ah a()
    {
      return new ah(this, (byte)0);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */