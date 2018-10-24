package com.whatsapp.memory.dump;

import com.whatsapp.memory.dump.a.a.c;
import com.whatsapp.memory.dump.a.d;
import com.whatsapp.memory.dump.a.e;
import com.whatsapp.util.Log;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public final class a
{
  private final File a;
  private final File b;
  private com.whatsapp.memory.dump.a.b c;
  
  public a(File paramFile1, File paramFile2)
  {
    this.a = paramFile1;
    this.b = paramFile2;
  }
  
  public final boolean a()
  {
    Log.i("HprofPersonalInfoCleaner/run/file " + this.a.getPath());
    try
    {
      if (this.c == null)
      {
        Log.i("HprofPersonalInfoCleaner/pass1/starting on file " + this.a.getPath());
        localObject = new c(this.a);
        d locald = new d((com.whatsapp.memory.dump.a.a.a)localObject);
        locald.a();
        ((com.whatsapp.memory.dump.a.a.a)localObject).h();
        Log.i("HprofPersonalInfoCleaner/pass1/finished on file " + this.a.getPath());
        this.c = locald.d;
      }
      Log.i("HprofPersonalInfoCleaner/pass2/starting on file " + this.a.getPath());
      Object localObject = new com.whatsapp.memory.dump.a.a.b(new c(this.a), new DataOutputStream(new BufferedOutputStream(new FileOutputStream(this.b))));
      new e((com.whatsapp.memory.dump.a.a.b)localObject, this.c).a();
      ((com.whatsapp.memory.dump.a.a.b)localObject).h();
      Log.i("HprofPersonalInfoCleaner/pass2/finished on file " + this.a.getPath());
      Log.i("HprofPersonalInfoCleaner/pass2/Written clean copy to " + this.b.getPath());
      Log.i("HprofPersonalInfoCleaner/run/Successfully cleaned");
      return true;
    }
    catch (Exception localException)
    {
      Log.d("HprofPersonalInfoCleaner/run/error", localException);
      return false;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;) {}
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/memory/dump/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */