package com.whatsapp;

import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ae;
import com.whatsapp.util.af;
import com.whatsapp.util.bk;
import java.io.File;
import java.io.IOException;

public class GifHelper
{
  public static void a(vv paramvv, File paramFile)
  {
    File localFile;
    Mp4Ops.LibMp4OperationResult localLibMp4OperationResult;
    try
    {
      localFile = paramvv.c.a("");
      localLibMp4OperationResult = applyGifTag(paramFile.getAbsolutePath(), localFile.getAbsolutePath());
      if (localLibMp4OperationResult == null)
      {
        Log.e("gif-helper/applyGifTag is null");
        throw new Mp4Ops.a(0, "result is null");
      }
    }
    catch (IOException paramvv)
    {
      Log.d("Could not access file or failed to move files properly", paramvv);
      throw new Mp4Ops.a(0, "Could not access file or failed to move files properly");
    }
    if (localLibMp4OperationResult.success)
    {
      if (!MediaFileUtils.a(paramvv, localFile, paramFile))
      {
        Log.e("gif-helper/applyGifTag failed to apply tag properly.  Renaming marked file to original filepath unsuccessful");
        throw new Mp4Ops.a(0, "applyGifTag failed to apply tag properly.  Renaming marked file to original filepath unsuccessful");
      }
    }
    else
    {
      Log.e("gif-helper/applyGifTag" + localLibMp4OperationResult.errorMessage);
      throw new Mp4Ops.a(localLibMp4OperationResult.errorCode, "invalid result, error_code: " + localLibMp4OperationResult.errorCode);
    }
    Log.d("applyGifTag succeeded");
  }
  
  public static boolean a(File paramFile)
  {
    return hasGifTag(paramFile.getAbsolutePath());
  }
  
  private static native Mp4Ops.LibMp4OperationResult applyGifTag(String paramString1, String paramString2);
  
  public static void b(vv paramvv, File paramFile)
  {
    File localFile;
    Mp4Ops.LibMp4OperationResult localLibMp4OperationResult;
    try
    {
      if (af.g(paramFile).c == 0)
      {
        Log.d("gif-helper/remove-audio-tracks no audio tracks found");
        return;
      }
      localFile = paramvv.c.a("");
      localLibMp4OperationResult = removeAudioTracks(paramFile.getAbsolutePath(), localFile.getAbsolutePath());
      if (localLibMp4OperationResult == null)
      {
        Log.e("gif-helper/remove-audio-tracks is null");
        throw new Mp4Ops.a(0, "result is null");
      }
    }
    catch (IOException paramvv)
    {
      Log.d("Could not access file or failed to move files properly", paramvv);
      throw new Mp4Ops.a(0, "Could not access file or failed to move files properly");
    }
    if (localLibMp4OperationResult.success)
    {
      if (!MediaFileUtils.a(paramvv, localFile, paramFile))
      {
        Log.e("gif-helper/remove-audio-tracks failed to apply tag properly.  Renaming marked file to original filepath unsuccessful");
        throw new Mp4Ops.a(0, "applyGifTag failed to apply tag properly.  Renaming marked file to original filepath unsuccessful");
      }
    }
    else
    {
      Log.e("gif-helper/remove-audio-tracks" + localLibMp4OperationResult.errorMessage);
      throw new Mp4Ops.a(localLibMp4OperationResult.errorCode, "invalid result, error_code: " + localLibMp4OperationResult.errorCode);
    }
  }
  
  private static native boolean hasGifTag(String paramString);
  
  private static native Mp4Ops.LibMp4OperationResult removeAudioTracks(String paramString1, String paramString2);
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/GifHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */