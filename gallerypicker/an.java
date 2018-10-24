package com.whatsapp.gallerypicker;

import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.whatsapp.doodle.DoodleView;
import com.whatsapp.doodle.a;
import com.whatsapp.doodle.a.a;
import com.whatsapp.doodle.a.b;
import com.whatsapp.doodle.a.e;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils.f;
import java.io.File;
import java.util.List;
import org.json.JSONException;

public class an
  extends Fragment
{
  Uri b;
  a c;
  final pv d = pv.a();
  
  final String S()
  {
    if (this.c.a.b()) {
      try
      {
        String str = this.c.a.getDoodle().e();
        return str;
      }
      catch (JSONException localJSONException)
      {
        Log.d("imagepreview/error-saving-doodle", localJSONException);
      }
    }
    return null;
  }
  
  void a() {}
  
  void a(Rect paramRect)
  {
    View localView = x();
    if (localView != null)
    {
      localView = localView.findViewById(2131755716);
      if (localView != null) {
        localView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
      }
    }
  }
  
  public void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    this.b = ((Uri)i().getParcelable("uri"));
    this.c = new a(l(), this.d, paramView, c());
    this.c.a.setStrictTouch(true);
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    return this.c.a(paramFloat1, paramFloat2);
  }
  
  void b() {}
  
  a c()
  {
    return new a();
  }
  
  void c(View paramView)
  {
    this.c.a(paramView);
  }
  
  public final void c(boolean paramBoolean)
  {
    try
    {
      super.c(paramBoolean);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.c("mediaprevoewfragment/setUserVisibleHint", localNullPointerException);
    }
  }
  
  class a
    implements a.a
  {
    a() {}
    
    public void a()
    {
      ((an.b)an.this.l()).q();
    }
    
    public void a(e parame) {}
    
    public void b()
    {
      ((an.b)an.this.l()).r();
    }
    
    public void c() {}
    
    public void d() {}
    
    public void e() {}
    
    public void f() {}
  }
  
  static abstract interface b
  {
    public abstract void a(Uri paramUri, long paramLong1, long paramLong2);
    
    public abstract void a(Uri paramUri1, Uri paramUri2, Rect paramRect, int paramInt);
    
    public abstract void a(Uri paramUri, boolean paramBoolean);
    
    public abstract File b(Uri paramUri);
    
    public abstract MediaFileUtils.f c(Uri paramUri);
    
    public abstract String d(Uri paramUri);
    
    public abstract Uri e(Uri paramUri);
    
    public abstract Rect f(Uri paramUri);
    
    public abstract Integer g(Uri paramUri);
    
    public abstract Point h(Uri paramUri);
    
    public abstract boolean i(Uri paramUri);
    
    public abstract ao n();
    
    public abstract View o();
    
    public abstract List<String> p();
    
    public abstract void q();
    
    public abstract void r();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */