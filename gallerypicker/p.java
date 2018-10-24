package com.whatsapp.gallerypicker;

import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.whatsapp.al;
import com.whatsapp.and;
import com.whatsapp.doodle.DoodleView;
import com.whatsapp.doodle.a;
import com.whatsapp.doodle.a.b;
import com.whatsapp.pj;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils.c;
import com.whatsapp.util.MediaFileUtils.f;
import com.whatsapp.videoplayback.e;
import com.whatsapp.videoplayback.o;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;

public final class p
  extends an
{
  private o a;
  private final and e = and.a();
  
  public static p a(Uri paramUri)
  {
    p localp = new p();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("uri", paramUri);
    localp.f(localBundle);
    return localp;
  }
  
  public final View a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return al.a(this.d, paramLayoutInflater, 2130903237, paramViewGroup, false);
  }
  
  final void a()
  {
    super.a();
    this.a.b();
    this.c.a.d();
    this.a.a().setKeepScreenOn(true);
  }
  
  public final void a(View paramView, Bundle paramBundle)
  {
    super.a(paramView, paramBundle);
    Object localObject = (an.b)l();
    File localFile = ((an.b)localObject).b(this.b);
    if (paramBundle == null)
    {
      paramBundle = ((an.b)localObject).d(this.b);
      if (paramBundle != null) {
        break label242;
      }
      paramBundle = ((an.b)localObject).c(this.b);
      if (paramBundle != null) {
        break label220;
      }
    }
    for (;;)
    {
      try
      {
        localObject = new MediaFileUtils.f(localFile);
        paramBundle = (Bundle)localObject;
        if (paramBundle.b())
        {
          f1 = paramBundle.b;
          if (!paramBundle.b()) {
            break label232;
          }
          f2 = paramBundle.a;
          paramBundle = new RectF(0.0F, 0.0F, f1, f2);
          this.c.a(paramBundle);
          this.c.b(paramBundle);
        }
      }
      catch (MediaFileUtils.c localc)
      {
        Log.e("gifpreview/bad video");
      }
      try
      {
        if (!pj.b(this.e, this.b)) {
          break label283;
        }
        paramBundle = new e(k(), localFile);
        this.a = paramBundle;
        this.a.a(true);
        this.a.e();
      }
      catch (IOException paramBundle)
      {
        b localb;
        paramBundle.printStackTrace();
        continue;
      }
      ((ViewGroup)paramView.findViewById(2131755791)).addView(this.a.a(), new FrameLayout.LayoutParams(-1, -1, 17));
      return;
      label220:
      continue;
      float f1 = paramBundle.a;
      continue;
      label232:
      float f2 = paramBundle.b;
      continue;
      label242:
      localb = new b();
      try
      {
        localb.a(paramBundle, k());
        this.c.a(localb);
      }
      catch (JSONException paramBundle)
      {
        for (;;)
        {
          Log.d("videopreview/error-loading-doodle", paramBundle);
        }
      }
      label283:
      paramBundle = o.a(k(), localFile.getAbsolutePath());
    }
  }
  
  final void b()
  {
    super.b();
    this.a.c();
    this.c.a.e();
    this.a.a().setKeepScreenOn(false);
  }
  
  final void c(View paramView)
  {
    super.c(paramView);
    paramView.findViewById(2131755442).setVisibility(8);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */