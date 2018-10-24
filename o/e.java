package com.whatsapp.o;

import com.whatsapp.util.OpusRecorder;
import java.io.File;

final class e
  extends a
{
  private OpusRecorder c;
  
  public e(String paramString)
  {
    this.a = new File(paramString);
    this.b = 16000;
    this.c = new OpusRecorder(paramString, 1);
  }
  
  public final void a()
  {
    this.c.prepare();
  }
  
  public final void b()
  {
    this.c.start();
  }
  
  public final void c()
  {
    this.c.stop();
  }
  
  public final void d()
  {
    this.c.close();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/o/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */