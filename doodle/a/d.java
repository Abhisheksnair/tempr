package com.whatsapp.doodle.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends e
{
  final Path a = new Path();
  final PointF b = new PointF();
  final ArrayList<PointF> c = new ArrayList();
  
  public d()
  {
    this.a.setFillType(Path.FillType.WINDING);
    this.f.setStyle(Paint.Style.STROKE);
  }
  
  public final String a()
  {
    return "pen";
  }
  
  public final void a(Canvas paramCanvas)
  {
    paramCanvas.drawPath(this.a, this.f);
  }
  
  public final void a(PointF paramPointF)
  {
    this.c.add(paramPointF);
    this.a.moveTo(paramPointF.x, paramPointF.y);
    this.b.set(paramPointF);
  }
  
  public final void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      PointF localPointF = (PointF)localIterator.next();
      localJSONArray.put((int)(localPointF.x * 100.0F));
      localJSONArray.put((int)(localPointF.y * 100.0F));
    }
    paramJSONObject.put("points", localJSONArray);
  }
  
  public final void b(PointF paramPointF)
  {
    if (this.b.equals(paramPointF)) {
      return;
    }
    this.c.add(paramPointF);
    this.a.quadTo(this.b.x, this.b.y, (paramPointF.x + this.b.x) / 2.0F, (paramPointF.y + this.b.y) / 2.0F);
    this.b.set(paramPointF);
  }
  
  public final void b(JSONObject paramJSONObject)
  {
    super.b(paramJSONObject);
    this.c.clear();
    this.a.reset();
    paramJSONObject = paramJSONObject.getJSONArray("points");
    int i = 0;
    if (i < paramJSONObject.length())
    {
      PointF localPointF = new PointF(paramJSONObject.getInt(i) / 100.0F, paramJSONObject.getInt(i + 1) / 100.0F);
      if (i == 0) {
        a(localPointF);
      }
      for (;;)
      {
        i += 2;
        break;
        b(localPointF);
      }
    }
  }
  
  public final boolean b()
  {
    return false;
  }
  
  public final boolean c()
  {
    return false;
  }
  
  public final boolean d()
  {
    return false;
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */