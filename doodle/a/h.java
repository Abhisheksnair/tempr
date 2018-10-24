package com.whatsapp.doodle.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import com.b.a.g;
import com.whatsapp.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Random;
import org.json.JSONObject;

public final class h
  extends e
{
  public static final int[] c = { 56413, -532786, -798046, -2774136, -5276073, -8629442 };
  public static final int[] j = { -1075643, -2053484, -2973577, -4748448, -7315394, -10996439 };
  private static final Random q = new Random();
  public boolean a;
  public int b = 0;
  private com.b.a.e k;
  private String l;
  private Context m;
  private int n;
  private long o = q.nextLong() % 1000L;
  private String p;
  
  public h(Context paramContext)
  {
    this.m = paramContext;
    this.f.setColor(0);
  }
  
  public h(Context paramContext, String paramString)
  {
    this.m = paramContext;
    this.l = paramString;
    this.f.setColor(0);
    j();
  }
  
  private void j()
  {
    try
    {
      this.k = com.b.a.e.a(this.m.getAssets(), "graphics/" + this.l);
      if ("e022.svg".equals(this.l))
      {
        this.n = 1;
        return;
      }
    }
    catch (IOException localIOException)
    {
      do
      {
        for (;;)
        {
          Log.e("failed to load SVG from " + this.l);
        }
        if ("1f577.svg".equals(this.l))
        {
          this.n = 2;
          return;
        }
        if ("1f595.svg".equals(this.l))
        {
          this.n = 3;
          return;
        }
      } while ((!"1f337.svg".equals(this.l)) && (!"1f331.svg".equals(this.l)));
      this.n = 4;
      return;
    }
    catch (g localg)
    {
      for (;;) {}
    }
  }
  
  public final String a()
  {
    return "svg";
  }
  
  public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    if (this.k != null)
    {
      RectF localRectF = this.k.a();
      float f2 = paramFloat3 - paramFloat1;
      float f1 = paramFloat4 - paramFloat2;
      if (f2 / f1 < localRectF.width() / localRectF.height()) {
        f1 = localRectF.height() * f2 / localRectF.width();
      }
      for (;;)
      {
        paramFloat1 = (paramFloat1 + paramFloat3) / 2.0F;
        paramFloat2 = (paramFloat2 + paramFloat4) / 2.0F;
        super.a(paramFloat1 - f2 / 2.0F, paramFloat2 - f1 / 2.0F, f2 / 2.0F + paramFloat1, f1 / 2.0F + paramFloat2);
        return;
        f2 = localRectF.width() * f1 / localRectF.height();
      }
    }
    super.a(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public final void a(int paramInt)
  {
    if (this.f.getColor() == paramInt) {
      return;
    }
    Object localObject;
    int i;
    String str;
    if (this.p == null) {
      try
      {
        InputStream localInputStream = this.m.getAssets().open("graphics/" + this.l);
        localObject = new ByteArrayOutputStream();
        byte[] arrayOfByte = new byte['Ѐ'];
        for (;;)
        {
          i = localInputStream.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          ((ByteArrayOutputStream)localObject).write(arrayOfByte, 0, i);
        }
        if (paramInt != 0) {
          break label154;
        }
      }
      catch (IOException localIOException)
      {
        Log.e("failed to load SVG from " + this.l);
      }
    } else {
      str = this.p;
    }
    label154:
    label563:
    for (;;)
    {
      try
      {
        this.k = com.b.a.e.a(str);
        super.a(paramInt);
        return;
        this.p = ((ByteArrayOutputStream)localObject).toString("UTF-8");
        break;
        localObject = String.format(Locale.US, "%06x", new Object[] { Integer.valueOf(paramInt & 0xFFFFFF) });
        if (this.b == 3)
        {
          str = "ffdc5d";
          str = this.p.replace("fill:#" + str, "fill:#" + (String)localObject);
          if (this.b != 3) {
            break label563;
          }
          i = c.length - 2;
          if (i < 0) {
            continue;
          }
          i1 = Color.red(paramInt);
          int i2 = Color.red(c[i]);
          int i3 = Color.red(c[(i + 1)]);
          if (((i2 <= i1) && (i1 <= i3)) || ((i3 <= i1) && (i1 <= i2)))
          {
            i1 = 1;
            if (i1 == 0) {
              continue;
            }
            i1 = (Color.blue(c[i]) - Color.blue(paramInt)) * 100 / (Color.blue(c[i]) - Color.blue(c[(i + 1)]));
            i2 = j[i];
            i = j[(i + 1)];
            i3 = Color.red(i2) * (100 - i1) / 100;
            int i4 = Color.red(i) * i1 / 100;
            int i5 = Color.green(i2) * (100 - i1) / 100;
            int i6 = Color.green(i) * i1 / 100;
            i2 = Color.blue(i2) * (100 - i1) / 100;
            i = Color.argb(255, i3 + i4, i5 + i6, Color.blue(i) * i1 / 100 + i2);
            localObject = String.format(Locale.US, "%06x", new Object[] { Integer.valueOf(i & 0xFFFFFF) });
            str = str.replace("fill:#ef9645", "fill:#" + (String)localObject);
          }
        }
        else
        {
          str = "ffcc4d";
          continue;
        }
        i1 = 0;
        continue;
        i -= 1;
      }
      catch (g localg)
      {
        Log.e("failed to load SVG from " + this.l);
        continue;
        i = 0;
        int i1 = 0;
      }
    }
  }
  
  public final void a(Canvas paramCanvas)
  {
    if (this.k == null) {
      return;
    }
    this.d.sort();
    paramCanvas.save();
    paramCanvas.rotate(this.e, this.d.centerX(), this.d.centerY());
    if (this.a) {
      paramCanvas.scale(-1.0F, 1.0F, this.d.centerX(), this.d.centerY());
    }
    float f1;
    if (this.h != 0L)
    {
      if (this.n != 1) {
        break label176;
      }
      f1 = 1.0F + 0.02F * (float)Math.sin(6.283185307179586D * ((this.o + this.h) % 1000L) / 1000.0D);
      paramCanvas.scale(f1, f1, this.d.centerX(), this.d.centerY());
    }
    for (;;)
    {
      paramCanvas.translate(this.d.left, this.d.top);
      this.k.a(paramCanvas, this.d);
      paramCanvas.restore();
      return;
      label176:
      float f2;
      if (this.n == 2)
      {
        f1 = (float)Math.sin(6.283185307179586D * (10L * (this.o + this.h) / 12L % 1000L) / 1000.0D);
        f2 = (float)Math.sin(6.283185307179586D * (15L * (this.o + this.h) / 12L % 1000L) / 1000.0D);
        paramCanvas.rotate(2.2F * f1, this.d.centerX(), this.d.centerY());
        paramCanvas.translate(this.d.centerX(), this.d.centerY());
        paramCanvas.skew(0.03F * f2, 0.0F);
        paramCanvas.translate(-this.d.centerX(), -this.d.centerY());
      }
      else if (this.n == 3)
      {
        long l1 = (this.o + this.h) % 4000L;
        if (l1 > 3300L) {
          paramCanvas.scale(1.0F, (float)Math.sin((4000L - l1) * 6.283185307179586D / 700.0D) * 0.1F + 1.0F, this.d.centerX(), this.d.bottom);
        }
      }
      else if (this.n == 4)
      {
        f1 = (float)Math.sin(6.283185307179586D * ((this.o + this.h) % 1000L) / 1000.0D);
        f2 = (float)Math.sin(6.283185307179586D * (9L * (this.o + this.h) / 12L % 1000L) / 1000.0D);
        paramCanvas.rotate(f1, this.d.centerX(), this.d.bottom);
        paramCanvas.translate(this.d.centerX(), this.d.bottom);
        paramCanvas.skew(0.02F * f2, 0.0F);
        paramCanvas.translate(-this.d.centerX(), -this.d.bottom);
      }
    }
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    paramJSONObject.put("file", this.l);
    paramJSONObject.put("flip", this.a);
    paramJSONObject.put("palette", this.b);
    super.a(paramJSONObject);
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    this.l = paramJSONObject.getString("file");
    this.a = paramJSONObject.getBoolean("flip");
    this.b = paramJSONObject.getInt("palette");
    j();
    super.b(paramJSONObject);
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final boolean c()
  {
    return this.b != 0;
  }
  
  public final int h()
  {
    return this.b;
  }
  
  public final boolean i()
  {
    return this.n != 0;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */