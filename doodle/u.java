package com.whatsapp.doodle;

import android.graphics.RectF;
import com.whatsapp.doodle.a.e;
import com.whatsapp.doodle.a.e.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

final class u
{
  final LinkedList<e> a = new LinkedList();
  
  public final void a(e parame)
  {
    this.a.add(parame);
  }
  
  static final class a
    extends u.e
  {
    private a() {}
    
    a(e parame)
    {
      super();
    }
    
    public final String a()
    {
      return "undo_add_shape";
    }
    
    public final void a(ArrayList<e> paramArrayList)
    {
      paramArrayList.remove(this.a);
    }
  }
  
  static final class b
    extends u.e
  {
    private int b;
    
    private b() {}
    
    b(e parame, List<e> paramList)
    {
      super();
      this.b = paramList.indexOf(parame);
    }
    
    public final String a()
    {
      return "undo_change_z_order";
    }
    
    public final void a(ArrayList<e> paramArrayList)
    {
      paramArrayList.remove(this.a);
      paramArrayList.add(this.b, this.a);
    }
  }
  
  static final class c
    extends u.e
  {
    private int b;
    
    private c() {}
    
    c(e parame, List<e> paramList)
    {
      super();
      this.b = paramList.indexOf(parame);
    }
    
    public final String a()
    {
      return "undo_delete_shape";
    }
    
    public final void a(ArrayList<e> paramArrayList)
    {
      paramArrayList.add(this.b, this.a);
    }
    
    public final void a(JSONObject paramJSONObject)
    {
      super.a(paramJSONObject);
      paramJSONObject.put("index", this.b);
    }
    
    public final void b(JSONObject paramJSONObject)
    {
      super.b(paramJSONObject);
      this.b = paramJSONObject.getInt("index");
    }
  }
  
  static final class d
    extends u.e
  {
    private e.b b;
    
    private d() {}
    
    d(e parame, e.b paramb)
    {
      super();
      this.b = paramb;
    }
    
    public final String a()
    {
      return "undo_modify_shape";
    }
    
    public final void a(ArrayList<e> paramArrayList)
    {
      this.a.a(this.b);
    }
    
    public final void a(JSONObject paramJSONObject)
    {
      super.a(paramJSONObject);
      paramJSONObject.put("color", this.b.c);
      paramJSONObject.put("rotate", this.b.a);
      paramJSONObject.put("strokeWidth", this.b.d);
      paramJSONObject.put("left", this.b.b.left);
      paramJSONObject.put("right", this.b.b.right);
      paramJSONObject.put("top", this.b.b.top);
      paramJSONObject.put("bottom", this.b.b.bottom);
    }
    
    public final void b(JSONObject paramJSONObject)
    {
      super.b(paramJSONObject);
      RectF localRectF = new RectF();
      localRectF.left = ((float)paramJSONObject.getDouble("left"));
      localRectF.right = ((float)paramJSONObject.getDouble("right"));
      localRectF.top = ((float)paramJSONObject.getDouble("top"));
      localRectF.bottom = ((float)paramJSONObject.getDouble("bottom"));
      int i = paramJSONObject.getInt("color");
      this.b = new e.b(localRectF, (float)paramJSONObject.getDouble("rotate"), i, (float)paramJSONObject.getDouble("strokeWidth"));
    }
  }
  
  static abstract class e
  {
    e a;
    
    e() {}
    
    e(e parame)
    {
      this.a = parame;
    }
    
    abstract String a();
    
    abstract void a(ArrayList<e> paramArrayList);
    
    void a(JSONObject paramJSONObject) {}
    
    void b(JSONObject paramJSONObject) {}
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/doodle/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */