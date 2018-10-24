package com.whatsapp.util;

import a.a.a.a.d;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public final class af
{
  private static final int A = a((byte)97, (byte)118, (byte)99, (byte)49);
  private static final int B = a((byte)109, (byte)112, (byte)52, (byte)118);
  private static final int C = a((byte)115, (byte)50, (byte)54, (byte)51);
  private static final int D = a((byte)104, (byte)118, (byte)99, (byte)49);
  private static final int E = a((byte)109, (byte)112, (byte)52, (byte)97);
  private static final int F = a((byte)115, (byte)97, (byte)109, (byte)114);
  private static final int G = a((byte)115, (byte)97, (byte)119, (byte)98);
  private static final int H = a((byte)101, (byte)115, (byte)100, (byte)115);
  private static final int I = a((byte)46, (byte)109, (byte)112, (byte)51);
  private static final int J = a((byte)101, (byte)99, (byte)45, (byte)51);
  private static final int K = a((byte)119, (byte)97, (byte)118, (byte)101);
  private static final int L = a((byte)115, (byte)111, (byte)117, (byte)110);
  private static final int M = a((byte)118, (byte)105, (byte)100, (byte)101);
  private static int N = 0;
  private static int O = 1;
  private static int P = 2;
  private static final byte[] a = { 102, 116, 121, 112 };
  private static final byte[] b = { 35, 33, 65, 77, 82, 10 };
  private static final byte[] c = { 35, 33, 65, 77, 82, 45, 87, 66, 10 };
  private static final byte[] d = { 77, 52, 65, 32 };
  private static final byte[] e = { 79, 103, 103, 83 };
  private static final byte[] f = { 79, 112, 117, 115, 72, 101, 97, 100 };
  private static final byte[] g = { 73, 68, 51 };
  private static final byte[] h = { 82, 73, 70, 70 };
  private static final ae.a i = new ae.a(0, 7, true);
  private static final ae.a j = new ae.a(0, 0, true);
  private static final byte[] k = { 87, 65, 86, 69 };
  private static final byte[] l = { 102, 109, 116, 32 };
  private static final byte[] m = { 100, 97, 116, 97 };
  private static final int[] n = { a(97, 100, 116, 108), a(99, 117, 101, 32), a(100, 97, 116, 97), a(102, 97, 99, 116), a(102, 109, 116, 32), a(105, 110, 115, 116), a(108, 97, 98, 108), a(108, 116, 120, 116), a(110, 111, 116, 101), a(112, 108, 115, 116), a(115, 109, 112, 108) };
  private static final ae o = new ae(0, 5, 7, true);
  private static final ae p = new ae(0, 0, 0, true);
  private static final byte[] q = { 113, 116, 32, 32 };
  private static final byte[] r = { 51, 103 };
  private static final int s = a((byte)109, (byte)111, (byte)111, (byte)118);
  private static final int t = a((byte)116, (byte)114, (byte)97, (byte)107);
  private static final int u = a((byte)116, (byte)107, (byte)104, (byte)100);
  private static final int v = a((byte)109, (byte)100, (byte)105, (byte)97);
  private static final int w = a((byte)104, (byte)100, (byte)108, (byte)114);
  private static final int x = a((byte)109, (byte)105, (byte)110, (byte)102);
  private static final int y = a((byte)115, (byte)116, (byte)98, (byte)108);
  private static final int z = a((byte)115, (byte)116, (byte)115, (byte)100);
  
  private static final int a(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    return (paramByte1 & 0xFF) << 24 | (paramByte2 & 0xFF) << 16 | (paramByte3 & 0xFF) << 8 | paramByte4 & 0xFF;
  }
  
  private static int a(InputStream paramInputStream, a parama)
  {
    try
    {
      parama = new byte[(int)(parama.a - parama.c)];
      if (a(paramInputStream, parama, 0, parama.length) != parama.length) {
        return 7;
      }
      if (parama[4] != 3)
      {
        Log.i("Did not find esds description tag - found: " + parama[4]);
        return 7;
      }
    }
    catch (Exception paramInputStream)
    {
      Log.i("Exception processing esds box: " + paramInputStream.toString());
      return 7;
    }
    paramInputStream = a(parama, 4, parama.length);
    int i1;
    int i2;
    if (paramInputStream == null)
    {
      Log.i("Did not find esds description details");
      return 7;
      if (parama[i1] != 4)
      {
        Log.i("Did not find esds config description tag - found: " + parama[i1]);
        return 7;
      }
      paramInputStream = a(parama, i1, parama.length);
      if (paramInputStream != null) {
        break label303;
      }
      Log.i("Did not find esds config details");
      return 7;
      Log.i("Did not find esds supported type - found: " + parama[(i2 + 1)]);
      return 7;
    }
    for (;;)
    {
      if ((parama[(i2 + 2)] & 0xFC) >> 2 != 5)
      {
        Log.i("Did not find stream type - found: " + parama[(i2 + 2)]);
        return 7;
        i1 = 1;
      }
      else
      {
        return i1;
        i1 = paramInputStream[0] + 3;
        int i3 = parama[i1];
        i2 = i1 + 1;
        i1 = i2;
        if ((i3 & 0x80) == 128) {
          i1 = i2 + 2;
        }
        i2 = i1;
        if ((i3 & 0x40) == 64) {
          i2 = i1 + (parama[i1] + 1);
        }
        i1 = i2;
        if ((i3 & 0x20) != 32) {
          break;
        }
        i1 = i2 + 2;
        break;
        label303:
        i2 = paramInputStream[0];
        switch (parama[(i2 + 1)])
        {
        case 64: 
        case 102: 
        case 103: 
        case 104: 
        default: 
          break;
        case 105: 
        case 107: 
          i1 = 2;
        }
      }
    }
  }
  
  private static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[36];
    byte[] arrayOfByte2 = new byte[8];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramInt);
    if (a(paramInputStream, arrayOfByte1, paramInt, 36 - paramInt) + paramInt != 36)
    {
      Log.i("Insufficient data for WAV file header");
      return 0;
    }
    if (!a(arrayOfByte1, 8, k))
    {
      Log.i("Not WAVE File type " + new String(arrayOfByte1, 8, k.length));
      return 7;
    }
    if (!a(arrayOfByte1, 12, l))
    {
      Log.i("Not WAVE chunk format " + new String(arrayOfByte1, 12, l.length));
      return 7;
    }
    paramInt = a((byte)0, (byte)0, arrayOfByte1[21], arrayOfByte1[20]);
    if ((80 != paramInt) && (85 != paramInt) && (5632 != paramInt) && (5648 != paramInt))
    {
      Log.i("RIFF/WAV container carries stream which is not one of supported MPEG audio streams " + paramInt);
      return 7;
    }
    paramInt = a(arrayOfByte1[19], arrayOfByte1[18], arrayOfByte1[17], arrayOfByte1[16]) + 16 + 4;
    int i1 = 36;
    for (;;)
    {
      long l1 = paramInt - i1;
      try
      {
        a(paramInputStream, l1);
        int i2 = a(paramInputStream, arrayOfByte2, 0, 8);
        i1 = paramInt + i2;
        if (i2 != 8)
        {
          Log.i("EOF reading WAVE chunk");
          return 7;
        }
      }
      catch (IOException paramInputStream)
      {
        Log.i("Excepton reading next chunk " + paramInputStream.toString());
        return 7;
      }
      paramInt = a(arrayOfByte2[0], arrayOfByte2[1], arrayOfByte2[2], arrayOfByte2[3]);
      if (d.a(n, paramInt)) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0)
      {
        Log.i("Unsupported WAVE chunk: " + new String(arrayOfByte2, 0, 4));
        return 7;
      }
      if (a(arrayOfByte2, 0, m)) {
        break;
      }
      paramInt = a(arrayOfByte2[7], arrayOfByte2[6], arrayOfByte2[5], arrayOfByte2[4]) + i1;
    }
    paramArrayOfByte = new byte[2];
    if (a(paramInputStream, paramArrayOfByte, 0, 2) != 2)
    {
      Log.i("EOF reading WAVE data");
      return 7;
    }
    if ((paramArrayOfByte[0] == -1) && ((byte)(paramArrayOfByte[1] & 0xE0) == -32))
    {
      Log.d("WAVE audio found aac/mp3");
      if ((paramArrayOfByte[1] & 0x6) == 0) {
        return 1;
      }
      return 2;
    }
    Log.i("Not ACC/MP3 WAVE data");
    return 7;
  }
  
  private static int a(InputStream paramInputStream, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i1 = Math.min(paramInt2, paramArrayOfByte.length - paramInt1);
    paramInt2 = 0;
    for (;;)
    {
      int i2;
      if (paramInt2 < i1)
      {
        i2 = paramInputStream.read(paramArrayOfByte, paramInt1 + paramInt2, i1 - paramInt2);
        if (i2 != -1) {}
      }
      else
      {
        return paramInt2;
      }
      paramInt2 += i2;
    }
  }
  
  private static long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 == -1L) {
      return -1L;
    }
    return paramLong1 - paramLong2;
  }
  
  private static ae.a a(InputStream paramInputStream)
  {
    Object localObject = new byte[36];
    int i1 = a(paramInputStream, (byte[])localObject, 0, 8);
    if (i1 < 8) {
      return j;
    }
    boolean bool;
    label240:
    int i3;
    if (a((byte[])localObject, 4, a))
    {
      Log.d("audio found MP4 type file");
      if (i1 + a(paramInputStream, (byte[])localObject, 8, 4) < 12) {
        return j;
      }
      localObject = a(paramInputStream, a(localObject[0], localObject[1], localObject[2], localObject[3]) - 12, -1L, new int[] { s });
      if (localObject == null)
      {
        Log.i("moov box not found");
        i1 = 7;
        if (7 != i1) {
          break label939;
        }
      }
      label939:
      for (bool = true;; bool = false)
      {
        return new ae.a(2, i1, bool);
        i1 = 0;
        long l1 = ((a)localObject).a;
        long l2 = ((a)localObject).c;
        paramInputStream = new b(paramInputStream, ((a)localObject).c);
        l1 = paramInputStream.a + (l1 - l2);
        for (;;)
        {
          if (paramInputStream.a < l1)
          {
            localObject = a(paramInputStream, 0L, l1 - paramInputStream.a, new int[] { t });
            if (localObject != null)
            {
              l2 = paramInputStream.a + ((a)localObject).a - ((a)localObject).c;
              i2 = i1;
              i1 = i2;
              if (paramInputStream.a < l2)
              {
                localObject = a(paramInputStream, 0L, l2 - paramInputStream.a, new int[] { v });
                if (localObject == null)
                {
                  Log.i("mdia box not found");
                  i1 = 7;
                  break;
                }
                long l3 = paramInputStream.a + ((a)localObject).a - ((a)localObject).c;
                localObject = a(paramInputStream, 0L, l3 - paramInputStream.a, new int[] { w });
                if (localObject == null)
                {
                  Log.i("hdlr box not found");
                  i1 = 7;
                  break;
                }
                long l4 = paramInputStream.a;
                long l5 = ((a)localObject).a;
                long l6 = ((a)localObject).c;
                a(paramInputStream, 16L - ((a)localObject).c);
                localObject = new byte[4];
                if (a(paramInputStream, (byte[])localObject, 0, 4) != 4)
                {
                  Log.i("hdlr box too short");
                  i1 = 7;
                  break;
                }
                i1 = a(localObject[0], localObject[1], localObject[2], localObject[3]);
                if (i1 == M)
                {
                  Log.i("video hdlr type not valid");
                  i1 = 7;
                  break;
                }
                if (i1 != L) {
                  Log.i("non sound hdlr type found " + new String(a(i1)));
                }
                for (;;)
                {
                  a(paramInputStream, l2 - paramInputStream.a);
                  break label240;
                  if ((i1 == L) && (i2 != 0))
                  {
                    Log.i("multiple hldr sound tracks found");
                    i1 = 6;
                    break;
                  }
                  localObject = a(paramInputStream, l4 + l5 - l6 - paramInputStream.a, l3 - paramInputStream.a, new int[] { x });
                  if (localObject == null)
                  {
                    Log.i("minf box not found");
                    i1 = 7;
                    break;
                  }
                  localObject = a(paramInputStream, 0L, paramInputStream.a + ((a)localObject).a - ((a)localObject).c - paramInputStream.a, new int[] { y });
                  if (localObject == null)
                  {
                    Log.i("stbl box not found");
                    i1 = 7;
                    break;
                  }
                  localObject = a(paramInputStream, 0L, paramInputStream.a + ((a)localObject).a - ((a)localObject).c - paramInputStream.a, new int[] { z });
                  if (localObject == null)
                  {
                    Log.i("stsd box not found");
                    i1 = 7;
                    break;
                  }
                  a(paramInputStream, 8L);
                  l3 = paramInputStream.a;
                  l4 = ((a)localObject).a;
                  l5 = ((a)localObject).c;
                  i1 = E;
                  i2 = F;
                  i3 = G;
                  localObject = a(paramInputStream, 0L, l3 + l4 - l5 - paramInputStream.a, new int[] { i1, i2, i3 });
                  if (localObject == null)
                  {
                    Log.i("content box not found");
                    i1 = 7;
                    break;
                  }
                  if (((a)localObject).b != E)
                  {
                    Log.i("Found media contents that wasn't m4a: " + new String(a(((a)localObject).b)));
                    i1 = 7;
                    break;
                  }
                  l3 = paramInputStream.a;
                  l4 = ((a)localObject).a;
                  l5 = ((a)localObject).c;
                  a(paramInputStream, 8L);
                  localObject = a(paramInputStream, b(paramInputStream)[1], l3 + l4 - l5 - paramInputStream.a, new int[] { H });
                  if (localObject == null)
                  {
                    Log.i("esds box not found");
                    i1 = 7;
                    break;
                  }
                  i2 = a(paramInputStream, (a)localObject);
                }
              }
            }
          }
        }
        Log.d("audio found: " + i1);
        break;
      }
    }
    if (a((byte[])localObject, 0, e))
    {
      Log.d("audio found Ogg type file");
      i1 = a(paramInputStream, (byte[])localObject, i1, 36 - i1) + i1;
      if (i1 < 27)
      {
        Log.i("not opus - too few bytes for first packet");
        return new ae.a(4, 7, true);
      }
      i2 = (localObject[26] & 0xFF) + 27;
      if (i1 < f.length + i2)
      {
        byte[] arrayOfByte = new byte[f.length + i2];
        System.arraycopy(localObject, 0, arrayOfByte, 0, i1);
        localObject = arrayOfByte;
        if (a(paramInputStream, arrayOfByte, i1, arrayOfByte.length - i1) + i1 < arrayOfByte.length)
        {
          Log.i("not opus - too few bytes");
          return new ae.a(4, 7, true);
        }
      }
      if (a((byte[])localObject, i2, f)) {
        return new ae.a(4, 5);
      }
      Log.i("not opus - header bytes don't match");
      return new ae.a(4, 7, true);
    }
    if (a((byte[])localObject, 0, h))
    {
      Log.d("audio found Riff type file");
      i1 = a(paramInputStream, (byte[])localObject, i1);
      if (7 == i1) {}
      for (bool = true;; bool = false) {
        return new ae.a(5, i1, bool);
      }
    }
    i1 += a(paramInputStream, (byte[])localObject, i1, 10 - i1);
    if (i1 < 10) {
      return j;
    }
    int i2 = i1;
    if (i1 == 10)
    {
      i2 = i1;
      if (a((byte[])localObject, 0, g))
      {
        Log.d("audio found ID3");
        a(paramInputStream, (localObject[6] & 0x7F) << 21 | (localObject[7] & 0x7F) << 14 | (localObject[8] & 0x7F) << 7 | localObject[9] & 0x7F);
        i1 = a(paramInputStream, (byte[])localObject, 0, 10);
        i2 = 2048;
        i3 = 0;
      }
    }
    for (;;)
    {
      if ((i1 > 0) && (i2 > 0) && (!a((byte[])localObject, 0, h)) && ((localObject[0] != -1) || ((byte)(localObject[1] & 0xE0) != -32)))
      {
        System.arraycopy(localObject, 1, localObject, 0, i1 - 1);
        i1 -= 1;
        if (i3 == 0) {
          if (paramInputStream.read((byte[])localObject, i1, 1) == -1)
          {
            localObject[i1] = 0;
            i2 = 0;
            i3 = 1;
          }
          else
          {
            i2 -= 1;
            i1 += 1;
          }
        }
      }
      else
      {
        Log.d("skipped " + (2048 - i2) + " after ID3");
        i2 = i1;
        if (i1 >= h.length)
        {
          i2 = i1;
          if (a((byte[])localObject, 0, h))
          {
            Log.d("audio found Riff after ID3");
            i1 = a(paramInputStream, (byte[])localObject, i1);
            if (7 == i1) {}
            for (bool = true;; bool = false) {
              return new ae.a(5, i1, bool);
            }
          }
        }
        if (i2 < 10) {
          return j;
        }
        if (i2 + a(paramInputStream, (byte[])localObject, i2, 36 - i2) < 36) {
          return j;
        }
        if ((localObject[0] == -1) && ((byte)(localObject[1] & 0xE0) == -32))
        {
          Log.d("audio found aac/mp3");
          if ((localObject[1] & 0x6) == 0) {
            return new ae.a(1, 1);
          }
          return new ae.a(1, 2);
        }
        if (a((byte[])localObject, 0, b)) {
          return new ae.a(1, 3);
        }
        if (a((byte[])localObject, 0, c)) {
          return new ae.a(1, 4);
        }
        return i;
      }
    }
  }
  
  private static ae a(InputStream paramInputStream, long paramLong, int paramInt)
  {
    Object localObject = a(paramInputStream, paramLong, -1L, new int[] { s });
    if (localObject == null)
    {
      Log.i("moov box not found");
      return o;
    }
    ae localae = new ae();
    localae.a = paramInt;
    paramLong = ((a)localObject).a;
    long l1 = ((a)localObject).c;
    b localb = new b(paramInputStream, ((a)localObject).c);
    paramLong = localb.a + (paramLong - l1);
    label142:
    int i1;
    int i2;
    long l2;
    long l3;
    long l4;
    for (;;)
    {
      if (localb.a < paramLong)
      {
        paramInputStream = a(localb, 0L, paramLong - localb.a, new int[] { t });
        if (paramInputStream != null)
        {
          l1 = localb.a + paramInputStream.a - paramInputStream.c;
          if (localb.a < l1)
          {
            i1 = u;
            i2 = v;
            paramInputStream = a(localb, 0L, l1 - localb.a, new int[] { i1, i2 });
            if (paramInputStream == null)
            {
              Log.i("tkmd/mdia box not found");
              return o;
            }
            if (paramInputStream.b != u) {
              break label1739;
            }
            l2 = localb.a;
            l3 = paramInputStream.a;
            l4 = paramInputStream.c;
            if (paramInputStream.a >= 92L)
            {
              localObject = new byte[(int)(paramInputStream.a - paramInputStream.c)];
              if (a(localb, (byte[])localObject, 0, localObject.length) != localObject.length) {
                throw new IOException("Unexpected eof reading tkhd");
              }
              i1 = localObject[0];
              if (i1 != 0) {
                break;
              }
              i1 = 76;
              label302:
              i2 = a(localObject[i1], localObject[(i1 + 1)], localObject[(i1 + 2)], localObject[(i1 + 3)]);
              i1 = a(localObject[(i1 + 4)], localObject[(i1 + 5)], localObject[(i1 + 6)], localObject[(i1 + 7)]);
              if ((i2 > 0) && (i1 > 0) && (localae.f <= 0) && (localae.e <= 0))
              {
                localae.f = (i1 >>> 16);
                localae.e = (i2 >>> 16);
              }
            }
            label414:
            paramInputStream = a(localb, l2 + l3 - l4 - localb.a, l1 - localb.a, new int[] { v });
          }
        }
      }
    }
    label1739:
    for (;;)
    {
      if (paramInputStream == null)
      {
        Log.i("mdia box not found");
        return o;
        if (i1 != 1) {
          break label414;
        }
        i1 = 88;
        if (paramInputStream.a >= 104L) {
          break label302;
        }
        break label414;
      }
      l2 = localb.a + paramInputStream.a - paramInputStream.c;
      paramInputStream = a(localb, 0L, l2 - localb.a, new int[] { w });
      if (paramInputStream == null)
      {
        Log.i("hdlr box not found");
        return o;
      }
      l3 = localb.a;
      l4 = paramInputStream.a;
      long l5 = paramInputStream.c;
      a(localb, 16L - paramInputStream.c);
      paramInputStream = new byte[4];
      if (a(localb, paramInputStream, 0, 4) != 4)
      {
        Log.i("hdlr box too short");
        return o;
      }
      int i3 = a(paramInputStream[0], paramInputStream[1], paramInputStream[2], paramInputStream[3]);
      if ((i3 != L) && (i3 != M)) {
        Log.d("non sound/video hdlr type found " + new String(a(i3)));
      }
      for (;;)
      {
        a(localb, l1 - localb.a);
        break label142;
        break;
        i1 = 0;
        if ((i3 == L) && (localae.c != 0))
        {
          Log.d("multiple hldr sound tracks found " + localae.c);
          if ((localae.c != 1) && (localae.c != 8))
          {
            localae.c = 6;
            return localae;
          }
          i2 = 1;
        }
        do
        {
          do
          {
            paramInputStream = a(localb, l3 + l4 - l5 - localb.a, l2 - localb.a, new int[] { x });
            if (paramInputStream != null) {
              break;
            }
            Log.i("minf box not found");
            return o;
            i2 = i1;
          } while (i3 != M);
          i2 = i1;
        } while (localae.b == 0);
        Log.i("multiple hldr video tracks found");
        return o;
        paramInputStream = a(localb, 0L, localb.a + paramInputStream.a - paramInputStream.c - localb.a, new int[] { y });
        if (paramInputStream == null)
        {
          Log.i("stbl box not found");
          return o;
        }
        paramInputStream = a(localb, 0L, localb.a + paramInputStream.a - paramInputStream.c - localb.a, new int[] { z });
        if (paramInputStream == null)
        {
          Log.i("stsd box not found");
          return o;
        }
        a(localb, 8L);
        l2 = localb.a + paramInputStream.a - paramInputStream.c;
        int i4;
        if (i3 == M)
        {
          i1 = A;
          i2 = B;
          i3 = C;
          i4 = D;
          paramInputStream = a(localb, 0L, l2 - localb.a, new int[] { i1, i2, i3, i4 });
          if (paramInputStream == null)
          {
            Log.i("video content box not found");
            return o;
          }
          if (paramInputStream.b == A) {
            localae.b = 2;
          } else if (paramInputStream.b == B) {
            localae.b = 3;
          } else if (paramInputStream.b == C) {
            localae.b = 1;
          } else if (paramInputStream.b == D) {
            localae.b = 4;
          }
        }
        else
        {
          i1 = E;
          i3 = F;
          i4 = G;
          int i5 = I;
          int i6 = J;
          paramInputStream = a(localb, 0L, l2 - localb.a, new int[] { i1, i3, i4, i5, i6 });
          if (paramInputStream == null)
          {
            Log.i("sound content box not found");
            return o;
          }
          if (i2 != 0)
          {
            i3 = 0;
            if (localae.c == 8)
            {
              i1 = i3;
              if (paramInputStream.b == E) {
                i1 = 1;
              }
            }
            while (i1 == 0)
            {
              Log.i("multiple hldr audio tracks found - not dolby");
              return o;
              i1 = i3;
              if (localae.c == 1)
              {
                i1 = i3;
                if (paramInputStream.b == J) {
                  i1 = 1;
                }
              }
            }
          }
          if (paramInputStream.b == E)
          {
            l2 = localb.a + paramInputStream.a - paramInputStream.c;
            a(localb, 8L);
            paramInputStream = b(localb);
            i1 = paramInputStream[0];
            i3 = paramInputStream[1];
            if ((i1 != N) && (paramInt == 7))
            {
              localObject = a(localb, i3, l2 - localb.a, new int[] { K, H });
              if (((a)localObject).b == K)
              {
                l3 = localb.a + ((a)localObject).a - ((a)localObject).c;
                localObject = a(localb, 0L, l3 - localb.a, new int[] { H });
                paramInputStream = (InputStream)localObject;
                if (localObject == null)
                {
                  a(localb, l3 - localb.a);
                  paramInputStream = a(localb, 0L, l2 - localb.a, new int[] { H });
                }
              }
            }
            while (paramInputStream == null)
            {
              Log.i("esds box not found");
              return o;
              paramInputStream = (InputStream)localObject;
              if (((a)localObject).b != H)
              {
                paramInputStream = null;
                continue;
                paramInputStream = a(localb, i3, l2 - localb.a, new int[] { H });
              }
            }
            localae.c = a(localb, paramInputStream);
            if (i2 != 0)
            {
              if (localae.c != 1)
              {
                Log.i("multiple hldr audio tracks found - not dolby mp4");
                return o;
              }
              localae.c = 8;
            }
            if (localae.c == 7)
            {
              localae.d = true;
              return localae;
            }
          }
          else if (paramInputStream.b == F)
          {
            localae.c = 3;
          }
          else if (paramInputStream.b == G)
          {
            localae.c = 4;
          }
          else
          {
            if (paramInputStream.b == I)
            {
              if (paramInt != 7) {
                Log.i(".mp3 box found in non-QuickTime file (?!)");
              }
              for (;;)
              {
                localae.c = 2;
                break;
                Log.d("file carries Mp3 audio stream");
              }
            }
            if (paramInputStream.b == J)
            {
              Log.d("file carries Dolby E-AC3 multichannel audio stream");
              localae.c = 8;
            }
          }
        }
      }
      Log.i("Details found: " + localae);
      return localae;
    }
  }
  
  private static a a(InputStream paramInputStream, long paramLong1, long paramLong2, int[] paramArrayOfInt)
  {
    Log.d("Looking for " + paramArrayOfInt.length + " boxes including: " + new String(a(paramArrayOfInt[0])));
    long l1 = paramLong2;
    if (paramLong1 > 0L)
    {
      if ((paramLong2 > 0L) && (paramLong1 > paramLong2)) {
        throw new IOException("Not enough bytes to skip");
      }
      a(paramInputStream, paramLong1);
      l1 = a(paramLong2, paramLong1);
    }
    byte[] arrayOfByte1 = new byte[8];
    int i1;
    int i2;
    int i3;
    if ((l1 == -1L) || (l1 > 0L))
    {
      i1 = a(paramInputStream, arrayOfByte1, 0, 8);
      if (i1 < 8) {
        throw new IOException("End of file looking for box header");
      }
      paramLong1 = a(l1, i1);
      i2 = 4;
      while (i2 < 8)
      {
        if (arrayOfByte1[i2] < 32)
        {
          Log.i("Found non character data in box type " + arrayOfByte1[i2]);
          return null;
        }
        i2 += 1;
      }
      i3 = a(arrayOfByte1[0], arrayOfByte1[1], arrayOfByte1[2], arrayOfByte1[3]);
      Log.d("Found box: " + new String(arrayOfByte1, 4, 4) + ' ' + i3);
      if (i3 == 0)
      {
        i3 = -1;
        i2 = i1;
        i1 = i3;
      }
    }
    for (;;)
    {
      if ((paramLong1 > 0L) && (paramLong1 < i1 - i2))
      {
        throw new IOException("Length of box too long to be in current input: " + i1 + '>' + paramLong1);
        if (i3 == 1)
        {
          byte[] arrayOfByte2 = new byte[8];
          i2 = i1 + a(paramInputStream, arrayOfByte2, 0, 8);
          if (i2 != 16) {
            throw new IOException("End of file looking for wide box length");
          }
          paramLong1 = a(paramLong1, i2);
          paramLong2 = a(arrayOfByte2[0], arrayOfByte2[1], arrayOfByte2[2], arrayOfByte2[3]) << 32 | a(arrayOfByte2[4], arrayOfByte2[5], arrayOfByte2[6], arrayOfByte2[7]);
          if (paramLong2 > 2147483647L) {
            throw new IOException("Length of box too long to be processed: " + paramLong2);
          }
          i1 = (int)paramLong2;
        }
      }
      else
      {
        i3 = a(arrayOfByte1[4], arrayOfByte1[5], arrayOfByte1[6], arrayOfByte1[7]);
        if (d.a(paramArrayOfInt, i3))
        {
          Log.d("Found matching box type: " + new String(a(i3)));
          return new a(i1, i3, i2);
        }
        Log.d("Did not find matching box type - found: " + new String(a(i3)));
        a(paramInputStream, i1 - i2);
        l1 = a(paramLong1, i1 - i2);
        break;
        return null;
      }
      i2 = i1;
      i1 = i3;
    }
  }
  
  public static String a(ae.a parama)
  {
    switch (parama.c)
    {
    case 6: 
    default: 
      throw new AssertionError("invalid audio type returned; " + parama);
    case 1: 
      if (parama.a == 2) {
        return "audio/mp4";
      }
      return "audio/aac";
    case 3: 
      return "audio/amr";
    case 2: 
      if (parama.a == 2) {
        return "audio/mp4";
      }
      return "audio/mpeg";
    case 5: 
      return "audio/ogg; codecs=opus";
    }
    Log.w("unsupported audio type; returning null mime type");
    return null;
  }
  
  public static String a(File paramFile)
  {
    paramFile = g(paramFile);
    if (paramFile.a == 7) {
      return "video/quicktime";
    }
    if (paramFile.a == 3) {
      return "video/3gpp";
    }
    return "video/mp4";
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        Log.w("empty audio mime type");
      }
    }
    do
    {
      return null;
      if ("audio/aac".equals(paramString)) {
        return "aac";
      }
      if ("audio/mp4".equals(paramString)) {
        return "m4a";
      }
      if ("audio/amr".equals(paramString)) {
        return "amr";
      }
      if ("audio/mpeg".equals(paramString)) {
        return "mp3";
      }
      if ("audio/ogg; codecs=opus".equals(paramString)) {
        return "opus";
      }
    } while (!paramBoolean);
    Log.w("unrecognized audio mime type; mimeType=" + paramString);
    return null;
  }
  
  private static void a(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    while (paramLong > 0L)
    {
      if (a(paramInputStream, arrayOfByte, 0, (int)Math.min(1024L, paramLong)) == -1) {
        throw new IOException("Unexpected EOF skipping " + paramLong);
      }
      paramLong -= 1024L;
    }
  }
  
  private static boolean a(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    int i1;
    if (paramArrayOfByte1.length - paramInt >= paramArrayOfByte2.length) {
      i1 = 0;
    }
    while (i1 < paramArrayOfByte2.length)
    {
      if (paramArrayOfByte1[(paramInt + i1)] != paramArrayOfByte2[i1]) {
        return false;
      }
      i1 += 1;
    }
    return true;
  }
  
  private static final byte[] a(int paramInt)
  {
    return new byte[] { paramInt >> 24, (byte)(paramInt >> 16), (byte)(paramInt >> 8), (byte)paramInt };
  }
  
  private static int[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    do
    {
      int i2;
      int i1;
      try
      {
        i2 = Math.min(paramInt2, paramInt1 + 4);
        paramInt2 = 0;
        i1 = paramInt1;
      }
      catch (Exception paramArrayOfByte)
      {
        Log.i("Exception processing esds box: " + paramArrayOfByte.toString());
        return null;
      }
      return new int[] { i1, paramInt2 };
      do
      {
        i1 += 1;
        paramInt2 = (paramArrayOfByte[i1] & 0x7F) + (paramInt2 << 7);
      } while ((paramInt1 < i2) && ((paramArrayOfByte[i1] & 0x80) == 128));
    } while (paramInt2 != 0);
    return null;
  }
  
  public static String b(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        Log.w("empty video mime type");
      }
    }
    do
    {
      return null;
      if ("video/mp4".equals(paramString)) {
        return "mp4";
      }
      if ("video/3gpp".equals(paramString)) {
        return "3gp";
      }
    } while (!paramBoolean);
    Log.w("unrecognized video mime type; mimeType=" + paramString);
    return null;
  }
  
  public static boolean b(File paramFile)
  {
    paramFile = f(paramFile);
    switch (paramFile.c)
    {
    case 6: 
    default: 
      throw new AssertionError("invalid audio file type returned; " + paramFile);
    case 1: 
    case 2: 
    case 3: 
    case 5: 
      return true;
    }
    return false;
  }
  
  private static int[] b(InputStream paramInputStream)
  {
    byte[] arrayOfByte = new byte[2];
    if (a(paramInputStream, arrayOfByte, 0, 2) != 2) {
      throw new IOException("Unexpected eof getting mp4a version");
    }
    int i1 = arrayOfByte[0];
    i1 = arrayOfByte[1] & 0xFF | (i1 & 0xFF) << 8;
    Log.i("mp4a box version: " + i1);
    if (i1 == 0) {
      return new int[] { N, 18 };
    }
    if (i1 == 1) {
      return new int[] { O, 34 };
    }
    if (i1 == 2) {
      return new int[] { P, 54 };
    }
    throw new IOException("Unexpected result getting mp4a version");
  }
  
  public static boolean c(File paramFile)
  {
    paramFile = g(paramFile);
    return ((paramFile.a == 2) || (paramFile.a == 3)) && ((paramFile.c == 3) || (paramFile.c == 4) || (paramFile.c == 2) || (paramFile.c == 1) || (paramFile.c == 0) || (paramFile.c == 8)) && ((paramFile.b == 2) || (paramFile.b == 1) || (paramFile.b == 3));
  }
  
  public static boolean d(File paramFile)
  {
    return g(paramFile).c == 8;
  }
  
  public static boolean e(File paramFile)
  {
    paramFile = g(paramFile);
    return ((paramFile.a == 2) || (paramFile.a == 3)) && ((paramFile.c == 3) || (paramFile.c == 4) || (paramFile.c == 2) || (paramFile.c == 1) || (paramFile.c == 0) || (paramFile.c == 8));
  }
  
  /* Error */
  public static ae.a f(File paramFile)
  {
    // Byte code:
    //   0: new 548	java/io/BufferedInputStream
    //   3: dup
    //   4: new 550	java/io/FileInputStream
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 553	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: invokespecial 556	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   15: astore_2
    //   16: aload_2
    //   17: astore_1
    //   18: aload_2
    //   19: invokestatic 558	com/whatsapp/util/af:a	(Ljava/io/InputStream;)Lcom/whatsapp/util/ae$a;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_1
    //   25: aload_2
    //   26: invokevirtual 561	java/io/InputStream:close	()V
    //   29: aload_1
    //   30: areturn
    //   31: astore_2
    //   32: new 199	java/lang/StringBuilder
    //   35: dup
    //   36: ldc_w 563
    //   39: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   42: aload_0
    //   43: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: aload_2
    //   50: invokestatic 566	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_1
    //   54: areturn
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: aload_2
    //   59: astore_1
    //   60: new 199	java/lang/StringBuilder
    //   63: dup
    //   64: ldc_w 568
    //   67: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   70: aload_0
    //   71: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: aload_3
    //   78: invokestatic 570	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   81: aload_2
    //   82: astore_1
    //   83: getstatic 108	com/whatsapp/util/af:i	Lcom/whatsapp/util/ae$a;
    //   86: astore_3
    //   87: aload_3
    //   88: astore_1
    //   89: aload_2
    //   90: ifnull -61 -> 29
    //   93: aload_2
    //   94: invokevirtual 561	java/io/InputStream:close	()V
    //   97: aload_3
    //   98: areturn
    //   99: astore_1
    //   100: new 199	java/lang/StringBuilder
    //   103: dup
    //   104: ldc_w 563
    //   107: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   110: aload_0
    //   111: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: aload_1
    //   118: invokestatic 566	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   121: aload_3
    //   122: areturn
    //   123: astore_2
    //   124: aconst_null
    //   125: astore_1
    //   126: aload_1
    //   127: ifnull +7 -> 134
    //   130: aload_1
    //   131: invokevirtual 561	java/io/InputStream:close	()V
    //   134: aload_2
    //   135: athrow
    //   136: astore_1
    //   137: new 199	java/lang/StringBuilder
    //   140: dup
    //   141: ldc_w 563
    //   144: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   147: aload_0
    //   148: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   151: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   154: aload_1
    //   155: invokestatic 566	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   158: goto -24 -> 134
    //   161: astore_2
    //   162: goto -36 -> 126
    //   165: astore_3
    //   166: goto -108 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramFile	File
    //   17	72	1	localObject1	Object
    //   99	19	1	localIOException1	IOException
    //   125	6	1	localObject2	Object
    //   136	19	1	localIOException2	IOException
    //   15	11	2	localBufferedInputStream	java.io.BufferedInputStream
    //   31	19	2	localIOException3	IOException
    //   57	37	2	localObject3	Object
    //   123	12	2	localObject4	Object
    //   161	1	2	localObject5	Object
    //   22	2	3	locala1	ae.a
    //   55	23	3	localIOException4	IOException
    //   86	36	3	locala2	ae.a
    //   165	1	3	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   25	29	31	java/io/IOException
    //   0	16	55	java/io/IOException
    //   93	97	99	java/io/IOException
    //   0	16	123	finally
    //   130	134	136	java/io/IOException
    //   18	23	161	finally
    //   60	81	161	finally
    //   83	87	161	finally
    //   18	23	165	java/io/IOException
  }
  
  /* Error */
  public static ae g(File paramFile)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_1
    //   2: new 548	java/io/BufferedInputStream
    //   5: dup
    //   6: new 550	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 553	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   14: invokespecial 556	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_3
    //   18: aload_3
    //   19: astore_2
    //   20: bipush 12
    //   22: newarray <illegal type>
    //   24: astore 4
    //   26: aload_3
    //   27: astore_2
    //   28: aload_3
    //   29: aload 4
    //   31: iconst_0
    //   32: bipush 12
    //   34: invokestatic 197	com/whatsapp/util/af:a	(Ljava/io/InputStream;[BII)I
    //   37: bipush 12
    //   39: if_icmpge +19 -> 58
    //   42: aload_3
    //   43: astore_2
    //   44: getstatic 133	com/whatsapp/util/af:p	Lcom/whatsapp/util/ae;
    //   47: astore 4
    //   49: aload 4
    //   51: astore_2
    //   52: aload_3
    //   53: invokevirtual 561	java/io/InputStream:close	()V
    //   56: aload_2
    //   57: areturn
    //   58: aload_3
    //   59: astore_2
    //   60: aload 4
    //   62: iconst_4
    //   63: getstatic 62	com/whatsapp/util/af:a	[B
    //   66: invokestatic 249	com/whatsapp/util/af:a	([BI[B)Z
    //   69: ifeq +87 -> 156
    //   72: aload_3
    //   73: astore_2
    //   74: ldc_w 572
    //   77: invokestatic 281	com/whatsapp/util/Log:d	(Ljava/lang/String;)V
    //   80: aload_3
    //   81: astore_2
    //   82: aload 4
    //   84: bipush 8
    //   86: getstatic 136	com/whatsapp/util/af:q	[B
    //   89: invokestatic 249	com/whatsapp/util/af:a	([BI[B)Z
    //   92: ifeq +44 -> 136
    //   95: bipush 7
    //   97: istore_1
    //   98: aload_3
    //   99: astore_2
    //   100: aload_3
    //   101: aload 4
    //   103: iconst_0
    //   104: baload
    //   105: aload 4
    //   107: iconst_1
    //   108: baload
    //   109: aload 4
    //   111: iconst_2
    //   112: baload
    //   113: aload 4
    //   115: iconst_3
    //   116: baload
    //   117: invokestatic 122	com/whatsapp/util/af:a	(BBBB)I
    //   120: bipush 12
    //   122: isub
    //   123: i2l
    //   124: iload_1
    //   125: invokestatic 574	com/whatsapp/util/af:a	(Ljava/io/InputStream;JI)Lcom/whatsapp/util/ae;
    //   128: astore 4
    //   130: aload 4
    //   132: astore_2
    //   133: goto -81 -> 52
    //   136: aload_3
    //   137: astore_2
    //   138: aload 4
    //   140: bipush 8
    //   142: getstatic 138	com/whatsapp/util/af:r	[B
    //   145: invokestatic 249	com/whatsapp/util/af:a	([BI[B)Z
    //   148: ifne -50 -> 98
    //   151: iconst_2
    //   152: istore_1
    //   153: goto -55 -> 98
    //   156: aload_3
    //   157: astore_2
    //   158: ldc_w 576
    //   161: invokestatic 216	com/whatsapp/util/Log:i	(Ljava/lang/String;)V
    //   164: aload_3
    //   165: astore_2
    //   166: getstatic 131	com/whatsapp/util/af:o	Lcom/whatsapp/util/ae;
    //   169: astore 4
    //   171: aload 4
    //   173: astore_2
    //   174: goto -122 -> 52
    //   177: astore_3
    //   178: new 199	java/lang/StringBuilder
    //   181: dup
    //   182: ldc_w 563
    //   185: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   188: aload_0
    //   189: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   192: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: aload_3
    //   196: invokestatic 566	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   199: aload_2
    //   200: areturn
    //   201: astore 4
    //   203: aconst_null
    //   204: astore_3
    //   205: aload_3
    //   206: astore_2
    //   207: new 199	java/lang/StringBuilder
    //   210: dup
    //   211: ldc_w 568
    //   214: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   217: aload_0
    //   218: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: aload 4
    //   226: invokestatic 570	com/whatsapp/util/Log:c	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   229: aload_3
    //   230: astore_2
    //   231: getstatic 133	com/whatsapp/util/af:p	Lcom/whatsapp/util/ae;
    //   234: astore 4
    //   236: aload 4
    //   238: astore_2
    //   239: aload_3
    //   240: ifnull -184 -> 56
    //   243: aload_3
    //   244: invokevirtual 561	java/io/InputStream:close	()V
    //   247: aload 4
    //   249: areturn
    //   250: astore_2
    //   251: new 199	java/lang/StringBuilder
    //   254: dup
    //   255: ldc_w 563
    //   258: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   261: aload_0
    //   262: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: aload_2
    //   269: invokestatic 566	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   272: aload 4
    //   274: areturn
    //   275: astore_3
    //   276: aconst_null
    //   277: astore_2
    //   278: aload_2
    //   279: ifnull +7 -> 286
    //   282: aload_2
    //   283: invokevirtual 561	java/io/InputStream:close	()V
    //   286: aload_3
    //   287: athrow
    //   288: astore_2
    //   289: new 199	java/lang/StringBuilder
    //   292: dup
    //   293: ldc_w 563
    //   296: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload_0
    //   300: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   303: invokevirtual 212	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: aload_2
    //   307: invokestatic 566	com/whatsapp/util/Log:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   310: goto -24 -> 286
    //   313: astore_3
    //   314: goto -36 -> 278
    //   317: astore 4
    //   319: goto -114 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	paramFile	File
    //   1	152	1	i1	int
    //   19	220	2	localObject1	Object
    //   250	19	2	localIOException1	IOException
    //   277	6	2	localObject2	Object
    //   288	19	2	localIOException2	IOException
    //   17	148	3	localBufferedInputStream	java.io.BufferedInputStream
    //   177	19	3	localIOException3	IOException
    //   204	40	3	localObject3	Object
    //   275	12	3	localObject4	Object
    //   313	1	3	localObject5	Object
    //   24	148	4	localObject6	Object
    //   201	24	4	localIOException4	IOException
    //   234	39	4	localae	ae
    //   317	1	4	localIOException5	IOException
    // Exception table:
    //   from	to	target	type
    //   52	56	177	java/io/IOException
    //   2	18	201	java/io/IOException
    //   243	247	250	java/io/IOException
    //   2	18	275	finally
    //   282	286	288	java/io/IOException
    //   20	26	313	finally
    //   28	42	313	finally
    //   44	49	313	finally
    //   60	72	313	finally
    //   74	80	313	finally
    //   82	95	313	finally
    //   100	130	313	finally
    //   138	151	313	finally
    //   158	164	313	finally
    //   166	171	313	finally
    //   207	229	313	finally
    //   231	236	313	finally
    //   20	26	317	java/io/IOException
    //   28	42	317	java/io/IOException
    //   44	49	317	java/io/IOException
    //   60	72	317	java/io/IOException
    //   74	80	317	java/io/IOException
    //   82	95	317	java/io/IOException
    //   100	130	317	java/io/IOException
    //   138	151	317	java/io/IOException
    //   158	164	317	java/io/IOException
    //   166	171	317	java/io/IOException
  }
  
  static final class a
  {
    protected final long a;
    protected final int b;
    protected final long c;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }
  
  static final class b
    extends InputStream
  {
    long a = 0L;
    byte[] b = new byte[1];
    private InputStream c = null;
    
    public b(InputStream paramInputStream, long paramLong)
    {
      this.c = paramInputStream;
      this.a = paramLong;
    }
    
    public final int available()
    {
      return this.c.available();
    }
    
    public final void close()
    {
      this.c.close();
    }
    
    public final void mark(int paramInt)
    {
      throw new IllegalStateException("Can't mark");
    }
    
    public final boolean markSupported()
    {
      return false;
    }
    
    public final int read()
    {
      int i = read(this.b, 0, 1);
      if (i == -1) {
        return -1;
      }
      if (i == 1) {
        return this.b[0] & 0xFF;
      }
      throw new IllegalStateException("OIS unexpected return value: " + i);
    }
    
    public final int read(byte[] paramArrayOfByte)
    {
      return read(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      paramInt1 = this.c.read(paramArrayOfByte, paramInt1, paramInt2);
      this.a += paramInt1;
      return paramInt1;
    }
    
    public final void reset()
    {
      throw new IllegalStateException("Can't reset");
    }
    
    public final long skip(long paramLong)
    {
      paramLong = this.c.skip(paramLong);
      this.a += paramLong;
      return paramLong;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/util/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */