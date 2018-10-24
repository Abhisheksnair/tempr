package com.whatsapp.doodle.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public ArrayList<e> a;
  public RectF b;
  public RectF c;
  public int d;
  public String e;
  
  public b() {}
  
  public b(RectF paramRectF1, RectF paramRectF2, int paramInt, ArrayList<e> paramArrayList)
  {
    this.b = paramRectF1;
    this.c = paramRectF2;
    this.a = paramArrayList;
    this.d = paramInt;
  }
  
  private boolean a(String[] paramArrayOfString)
  {
    if (this.a == null) {
      return false;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (a.a.a.a.d.a(paramArrayOfString, ((e)localIterator.next()).a())) {
        return true;
      }
    }
    return false;
  }
  
  public final void a(long paramLong)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).h = paramLong;
    }
  }
  
  public final void a(Bitmap paramBitmap, int paramInt)
  {
    Canvas localCanvas = new Canvas(paramBitmap);
    float f1;
    float f2;
    if (paramInt % 180 == 90)
    {
      f1 = paramBitmap.getHeight() / this.b.width();
      f2 = paramBitmap.getWidth() / this.b.height();
      localCanvas.scale(f1, f2);
      localCanvas.rotate(paramInt);
      if (paramInt != 90) {
        break label123;
      }
      localCanvas.translate(0.0F, -this.b.height());
    }
    label123:
    label178:
    do
    {
      for (;;)
      {
        a(localCanvas);
        return;
        f1 = paramBitmap.getWidth() / this.b.width();
        f2 = paramBitmap.getHeight() / this.b.height();
        break;
        if (paramInt == 180)
        {
          localCanvas.translate(-this.b.width(), -this.b.height());
        }
        else
        {
          if (paramInt != 270) {
            break label178;
          }
          localCanvas.translate(-this.b.width(), 0.0F);
        }
      }
    } while (paramInt == 0);
    throw new IllegalArgumentException();
  }
  
  public final void a(Canvas paramCanvas)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((e)localIterator.next()).a(paramCanvas);
    }
  }
  
  public final void a(File paramFile)
  {
    String str = e();
    FileWriter localFileWriter = new FileWriter(paramFile);
    paramFile = null;
    try
    {
      localFileWriter.write(str);
      localFileWriter.close();
      return;
    }
    catch (Throwable localThrowable)
    {
      paramFile = localThrowable;
      throw localThrowable;
    }
    finally
    {
      if (paramFile == null) {}
    }
    try
    {
      localFileWriter.close();
      for (;;)
      {
        throw ((Throwable)localObject);
        localFileWriter.close();
      }
    }
    catch (Throwable paramFile)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public final void a(File paramFile, Context paramContext)
  {
    // Byte code:
    //   0: new 123	java/io/BufferedReader
    //   3: dup
    //   4: new 125	java/io/FileReader
    //   7: dup
    //   8: aload_1
    //   9: invokespecial 126	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   12: invokespecial 129	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore 4
    //   17: aconst_null
    //   18: astore_3
    //   19: new 131	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 132	java/lang/StringBuilder:<init>	()V
    //   26: astore_1
    //   27: aload 4
    //   29: invokevirtual 135	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   32: astore 5
    //   34: aload 5
    //   36: ifnull +32 -> 68
    //   39: aload_1
    //   40: aload 5
    //   42: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: goto -19 -> 27
    //   49: astore_1
    //   50: aload_1
    //   51: athrow
    //   52: astore_2
    //   53: aload_1
    //   54: astore_3
    //   55: aload_2
    //   56: astore_1
    //   57: aload_3
    //   58: ifnull +25 -> 83
    //   61: aload 4
    //   63: invokevirtual 140	java/io/BufferedReader:close	()V
    //   66: aload_1
    //   67: athrow
    //   68: aload_0
    //   69: aload_1
    //   70: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: aload_2
    //   74: invokevirtual 146	com/whatsapp/doodle/a/b:a	(Ljava/lang/String;Landroid/content/Context;)V
    //   77: aload 4
    //   79: invokevirtual 140	java/io/BufferedReader:close	()V
    //   82: return
    //   83: aload 4
    //   85: invokevirtual 140	java/io/BufferedReader:close	()V
    //   88: goto -22 -> 66
    //   91: astore_2
    //   92: goto -26 -> 66
    //   95: astore_1
    //   96: goto -39 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	b
    //   0	99	1	paramFile	File
    //   0	99	2	paramContext	Context
    //   18	40	3	localFile	File
    //   15	69	4	localBufferedReader	java.io.BufferedReader
    //   32	9	5	str	String
    // Exception table:
    //   from	to	target	type
    //   19	27	49	java/lang/Throwable
    //   27	34	49	java/lang/Throwable
    //   39	46	49	java/lang/Throwable
    //   68	77	49	java/lang/Throwable
    //   50	52	52	finally
    //   61	66	91	java/lang/Throwable
    //   19	27	95	finally
    //   27	34	95	finally
    //   39	46	95	finally
    //   68	77	95	finally
  }
  
  public final void a(String paramString, Context paramContext)
  {
    paramString = new JSONObject(paramString);
    this.b = new RectF();
    this.b.left = e.b(paramString.getInt("l"));
    this.b.top = e.b(paramString.getInt("t"));
    this.b.right = e.b(paramString.getInt("r"));
    this.b.bottom = e.b(paramString.getInt("b"));
    this.c = new RectF();
    this.c.left = e.b(paramString.getInt("crop-l"));
    this.c.top = e.b(paramString.getInt("crop-t"));
    this.c.right = e.b(paramString.getInt("crop-r"));
    this.c.bottom = e.b(paramString.getInt("crop-b"));
    this.d = paramString.getInt("rotate");
    JSONArray localJSONArray = paramString.getJSONArray("shapes");
    this.a = new ArrayList();
    int j = 0;
    if (j < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.getJSONObject(j);
      paramString = localJSONObject.getString("type");
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label300:
          paramString = null;
        }
        break;
      }
      for (;;)
      {
        if (paramString != null)
        {
          paramString.b(localJSONObject);
          this.a.add(paramString);
        }
        j += 1;
        break;
        if (!paramString.equals("pen")) {
          break label300;
        }
        i = 0;
        break label300;
        if (!paramString.equals("arrow")) {
          break label300;
        }
        i = 1;
        break label300;
        if (!paramString.equals("oval")) {
          break label300;
        }
        i = 2;
        break label300;
        if (!paramString.equals("thinking-bubble")) {
          break label300;
        }
        i = 3;
        break label300;
        if (!paramString.equals("speech-bubble-oval")) {
          break label300;
        }
        i = 4;
        break label300;
        if (!paramString.equals("speech-bubble-rect")) {
          break label300;
        }
        i = 5;
        break label300;
        if (!paramString.equals("svg")) {
          break label300;
        }
        i = 6;
        break label300;
        if (!paramString.equals("text")) {
          break label300;
        }
        i = 7;
        break label300;
        paramString = new d();
        continue;
        paramString = new a();
        continue;
        paramString = new c();
        continue;
        paramString = new j();
        continue;
        paramString = new f();
        continue;
        paramString = new g();
        continue;
        paramString = new h(paramContext);
        continue;
        paramString = new i(paramContext);
      }
    }
  }
  
  public final boolean a()
  {
    return (this.a == null) || (this.a.isEmpty());
  }
  
  public final boolean b()
  {
    return a(new String[] { "text" });
  }
  
  public final boolean c()
  {
    return a(new String[] { "pen" });
  }
  
  public final boolean d()
  {
    return a(new String[] { "arrow", "oval", "thinking-bubble", "speech-bubble-oval", "speech-bubble-rect", "svg" });
  }
  
  public final String e()
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("version", 1);
    localJSONObject1.put("l", e.c(this.b.left));
    localJSONObject1.put("t", e.c(this.b.top));
    localJSONObject1.put("r", e.c(this.b.right));
    localJSONObject1.put("b", e.c(this.b.bottom));
    localJSONObject1.put("crop-l", e.c(this.c.left));
    localJSONObject1.put("crop-t", e.c(this.c.top));
    localJSONObject1.put("crop-r", e.c(this.c.right));
    localJSONObject1.put("crop-b", e.c(this.c.bottom));
    localJSONObject1.put("rotate", this.d);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      e locale = (e)localIterator.next();
      JSONObject localJSONObject2 = new JSONObject();
      locale.a(localJSONObject2);
      localJSONArray.put(localJSONObject2);
    }
    localJSONObject1.put("shapes", localJSONArray);
    return localJSONObject1.toString();
  }
  
  public final boolean f()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      if (((e)localIterator.next()).i()) {
        return true;
      }
    }
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */