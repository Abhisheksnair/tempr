package com.whatsapp;

import android.os.SystemClock;
import com.whatsapp.fieldstats.events.ba;
import com.whatsapp.fieldstats.l;
import com.whatsapp.k.h;
import com.whatsapp.util.Log;
import java.io.File;
import java.io.IOException;

public class Mp4Ops
{
  private static final h a = new h(100, 1000);
  
  public static LibMp4OperationResult a(File paramFile, boolean paramBoolean)
  {
    com.whatsapp.k.d locald = com.whatsapp.k.c.a("Mp4Ops_integrityCheck");
    locald.a();
    Log.i("mp4ops/check/start");
    LibMp4OperationResult localLibMp4OperationResult1 = null;
    int i = 0;
    LibMp4OperationResult localLibMp4OperationResult2;
    for (;;)
    {
      localLibMp4OperationResult2 = localLibMp4OperationResult1;
      if (i < 5) {
        try
        {
          localLibMp4OperationResult1 = mp4check(paramFile.getAbsolutePath(), paramBoolean);
          localLibMp4OperationResult2 = localLibMp4OperationResult1;
          if (!localLibMp4OperationResult1.success)
          {
            localLibMp4OperationResult2 = localLibMp4OperationResult1;
            if (localLibMp4OperationResult1.ioException)
            {
              SystemClock.sleep(100L);
              i += 1;
            }
          }
        }
        catch (Error paramFile)
        {
          Log.d("mp4ops/integration fail/", paramFile);
          throw new a(0, "integrity check error", new Throwable());
        }
      }
    }
    if (!localLibMp4OperationResult2.success)
    {
      Log.e("mp4ops/check/error_message/" + localLibMp4OperationResult2.errorMessage);
      throw new a(localLibMp4OperationResult2.errorCode, "integrity check failed, error_code: " + localLibMp4OperationResult2.errorCode, new Throwable());
    }
    locald.b();
    Log.i("mp4ops/check/finished: " + locald.e());
    return localLibMp4OperationResult2;
  }
  
  public static void a(com.whatsapp.util.a.c paramc, File paramFile, Exception paramException, String paramString)
  {
    if ((av.e()) && (av.g())) {
      return;
    }
    File localFile = new File("/sdcard/WhatsApp/Media/WhatsApp Video/", "video.fos");
    boolean bool = b(localFile.getAbsolutePath(), paramFile.getAbsolutePath());
    Log.i("mp4ops/forensic-upload/create result=" + bool);
    if (bool) {}
    try
    {
      paramFile = a.a.a.a.d.c(localFile);
      Log.d("UNCAUGHT EXCEPTION", new RuntimeException("LibMp4Operations " + paramString + " failed (file): " + paramException.getMessage()));
      paramc.a(false, false, true, false, null, paramFile, "attachment");
      if (!bool) {
        paramc.a("LibMp4Operations " + paramString + " failed: " + paramException.getMessage(), false, null, -1);
      }
      localFile.delete();
      return;
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        Log.d("mp4ops/forensic-upload/", paramFile);
        bool = false;
      }
    }
  }
  
  public static void a(vv paramvv, File paramFile)
  {
    com.whatsapp.k.d locald = com.whatsapp.k.c.a("Mp4Ops_integrityCheckAndRepair");
    locald.a();
    Log.i("mp4ops/checkAndRepair/start");
    paramvv = paramvv.b();
    Log.i("mp4ops/checkAndRepair/repairFileName.exists" + paramvv.exists());
    LibMp4CheckAndRepairResult localLibMp4CheckAndRepairResult;
    try
    {
      localLibMp4CheckAndRepairResult = mp4checkAndRepair(paramFile.getAbsolutePath(), paramvv.getAbsolutePath());
      if (localLibMp4CheckAndRepairResult.success) {
        break label177;
      }
      if (localLibMp4CheckAndRepairResult.repaired) {
        paramvv.delete();
      }
      Log.e("mp4ops/checkAndRepair/error_message/" + localLibMp4CheckAndRepairResult.errorMessage);
      if (localLibMp4CheckAndRepairResult.ioException) {
        throw new IOException("No space");
      }
    }
    catch (Error paramvv)
    {
      Log.d("mp4ops/integration fail/", paramvv);
      throw new a(0, "integrity check error", new Throwable());
    }
    throw new a(localLibMp4CheckAndRepairResult.errorCode, "integrity check/repair failed, error_code: " + localLibMp4CheckAndRepairResult.errorCode, new Throwable());
    label177:
    locald.b();
    Log.i("mp4ops/checkAndRepair/finished: " + locald.e());
    if (localLibMp4CheckAndRepairResult.repaired)
    {
      Log.i("mp4ops/checkAndRepair/file_is_repaired, new file created and renamed: " + paramvv.getAbsolutePath());
      if (!paramvv.renameTo(paramFile))
      {
        Log.i("mp4ops/checkAndRepair/rename_failed");
        throw new IOException("unable to rename file");
      }
    }
    else
    {
      Log.i("mp4ops/checkAndRepair/file_repair_not_needed");
    }
  }
  
  public static void a(File paramFile1, File paramFile2)
  {
    com.whatsapp.k.d locald = com.whatsapp.k.c.a("Mp4Ops_removeDolbyEAC3Track");
    locald.a();
    Log.i("mp4ops/removeDolbyEAC3Track/start");
    try
    {
      paramFile1 = mp4removeDolbyEAC3Track(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath());
      if (paramFile1.success) {
        break label138;
      }
      Log.e("mp4ops/check/error_message/" + paramFile1.errorMessage);
      if (paramFile1.ioException) {
        throw new IOException("No space");
      }
    }
    catch (Error paramFile1)
    {
      Log.d("mp4ops/removeDolbyEAC3Track/", paramFile1);
      throw new a(0, "integrity check error", new Throwable());
    }
    throw new a(paramFile1.errorCode, "removeDolbyEAC3Track failed, error_code: " + paramFile1.errorCode, new Throwable());
    label138:
    locald.b();
    Log.i("mp4ops/removeDolbyEAC3Track/finished: " + locald.e());
  }
  
  public static void a(File paramFile1, File paramFile2, long paramLong1, long paramLong2)
  {
    com.whatsapp.k.d locald = com.whatsapp.k.c.a("Mp4Ops_trim");
    locald.a();
    Log.i("mp4ops/trim/start from " + paramLong1 + " to " + paramLong2 + " size:" + paramFile1.length());
    if (((paramLong1 <= 0L) && (paramLong2 <= 0L)) || (paramLong1 == paramLong2)) {
      throw new IllegalArgumentException("timeFrom:" + paramLong1 + " timeTo:" + paramLong2);
    }
    float f1 = (float)paramLong1 / 1000.0F;
    float f2 = (float)(paramLong2 - paramLong1) / 1000.0F;
    try
    {
      paramFile1 = mp4mux(paramFile1.getAbsolutePath(), paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath(), f1, f1, f2, -1.0F, -1);
      if (paramFile1 == null)
      {
        Log.e("mp4ops/trim/result is null");
        throw new a(0, "result is null", new Throwable());
      }
    }
    catch (Error paramFile1)
    {
      Log.e("mp4ops/trim/failed: mp4mux error, exiting");
      throw new a(0, paramFile1.getMessage(), new Throwable());
    }
    Log.i("mp4ops/trim/result: " + paramFile1.success);
    if (!paramFile1.success)
    {
      Log.e("mp4ops/trim/error_message/" + paramFile1.errorMessage);
      if (paramFile1.ioException) {
        throw new IOException("No space");
      }
      paramFile2 = new StringBuilder("invalid result, error_code: ").append(paramFile1.errorCode);
      throw new a(paramFile1.errorCode, paramFile2.toString(), new Throwable());
    }
    locald.b();
    Log.i("mp4ops/trim/finished: size:" + paramFile2.length());
  }
  
  public static void a(File paramFile1, File paramFile2, File paramFile3, int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    com.whatsapp.k.d locald = com.whatsapp.k.c.a("Mp4Ops_mux");
    locald.a();
    Log.i("mp4ops/mux/start");
    float f1 = (float)paramLong1 / 1000.0F;
    float f2 = (float)paramLong3 / 1000.0F;
    float f3 = (float)paramLong2 / 1000.0F;
    if (paramFile2 == null) {
      paramFile2 = "";
    }
    for (;;)
    {
      try
      {
        paramFile2 = mp4mux(paramFile2, paramFile3, paramFile1.getAbsolutePath(), f1, 0.0F, f2, f3, paramInt);
        if (paramFile2 != null) {
          break label149;
        }
        Log.e("mp4ops/mux/result is null");
        throw new a(0, "result is null", new Throwable());
      }
      catch (Error paramFile1)
      {
        Log.e("mp4ops/mux/failed: mp4mux error, exiting");
        throw new a(0, paramFile1.getMessage(), new Throwable());
      }
      paramFile2 = paramFile2.getAbsolutePath();
      break label291;
      paramFile3 = paramFile3.getAbsolutePath();
      continue;
      label149:
      Log.i("mp4ops/mux/result: " + paramFile2.success);
      if (!paramFile2.success)
      {
        Log.e("mp4ops/mux/error_message/" + paramFile2.errorMessage);
        if (paramFile2.ioException) {
          throw new IOException("No space");
        }
        paramFile1 = new StringBuilder("invalid result, error_code: ").append(paramFile2.errorCode);
        throw new a(paramFile2.errorCode, paramFile1.toString(), new Throwable());
      }
      locald.b();
      Log.i("mp4ops/mux/finished, size:" + paramFile1.length());
      return;
      label291:
      if (paramFile3 == null) {
        paramFile3 = "";
      }
    }
  }
  
  public static void a(File paramFile, boolean paramBoolean, long paramLong)
  {
    com.whatsapp.k.d locald = com.whatsapp.k.c.a("Mp4Ops_streamcheck");
    locald.a();
    Log.i("mp4ops/check/start");
    LibMp4OperationResult localLibMp4OperationResult1 = null;
    int i = 0;
    LibMp4OperationResult localLibMp4OperationResult2;
    for (;;)
    {
      localLibMp4OperationResult2 = localLibMp4OperationResult1;
      if (i < 5) {
        try
        {
          localLibMp4OperationResult1 = mp4streamcheck(paramFile.getAbsolutePath(), paramBoolean, paramLong);
          localLibMp4OperationResult2 = localLibMp4OperationResult1;
          if (!localLibMp4OperationResult1.success)
          {
            localLibMp4OperationResult2 = localLibMp4OperationResult1;
            if (localLibMp4OperationResult1.ioException)
            {
              SystemClock.sleep(100L);
              i += 1;
            }
          }
        }
        catch (Error paramFile)
        {
          Log.d("mp4ops/integration fail/", paramFile);
          throw new a(0, "stream integrity check error", new Throwable());
        }
      }
    }
    if (!localLibMp4OperationResult2.success)
    {
      Log.e("mp4ops/streamcheck/error_message/" + localLibMp4OperationResult2.errorMessage);
      throw new a(localLibMp4OperationResult2.errorCode, "integrity check failed, error_code: " + localLibMp4OperationResult2.errorCode, new Throwable());
    }
    locald.b();
    Log.i("mp4ops/streamcheck/finished: " + locald.e());
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (a.a(1))
    {
      ba localba = new ba();
      localba.d = paramString1;
      localba.e = paramString2;
      localba.a = Boolean.valueOf(true);
      localba.b = Boolean.valueOf(false);
      l.a(u.a(), localba, a.b(1));
    }
  }
  
  public static void a(String paramString1, String paramString2, Exception paramException)
  {
    ba localba = new ba();
    localba.d = paramString1;
    localba.e = paramString2;
    localba.a = Boolean.valueOf(false);
    localba.b = Boolean.valueOf(false);
    localba.c = Long.valueOf(((a)paramException).a);
    l.a(u.a(), localba);
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = mp4forensic(400, paramString1, paramString2);
      Log.e("mp4ops/forensic ret=" + bool);
      return bool;
    }
    catch (Error paramString1)
    {
      Log.d("videotranscodder/forensic fail/", paramString1);
    }
    return false;
  }
  
  private static native LibMp4OperationResult mp4check(String paramString, boolean paramBoolean);
  
  private static native LibMp4CheckAndRepairResult mp4checkAndRepair(String paramString1, String paramString2);
  
  private static native boolean mp4forensic(int paramInt, String paramString1, String paramString2);
  
  private static native LibMp4OperationResult mp4mux(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  private static native LibMp4OperationResult mp4removeDolbyEAC3Track(String paramString1, String paramString2);
  
  private static native LibMp4OperationResult mp4streamcheck(String paramString, boolean paramBoolean, long paramLong);
  
  public static class LibMp4CheckAndRepairResult
  {
    public int errorCode;
    public String errorMessage;
    public boolean ioException;
    public boolean repaired;
    public boolean success;
    
    public LibMp4CheckAndRepairResult(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString, boolean paramBoolean3)
    {
      this.success = paramBoolean1;
      this.repaired = paramBoolean2;
      this.errorCode = paramInt;
      this.errorMessage = paramString;
      this.ioException = paramBoolean3;
    }
  }
  
  public static class LibMp4OperationResult
  {
    public int errorCode;
    public String errorMessage;
    public boolean ioException;
    public int rotationDegrees;
    public boolean success;
    
    public LibMp4OperationResult(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, String paramString)
    {
      this.success = paramBoolean1;
      this.ioException = paramBoolean2;
      this.errorCode = paramInt1;
      this.errorMessage = paramString;
      this.rotationDegrees = paramInt2;
    }
  }
  
  public static final class a
    extends Exception
  {
    public final int a;
    
    public a(int paramInt, String paramString)
    {
      super();
      this.a = paramInt;
    }
    
    public a(int paramInt, String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
      this.a = paramInt;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/Mp4Ops.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */