package com.whatsapp.wallpaper;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.whatsapp.PhotoView;
import com.whatsapp.PhotoView.c;
import com.whatsapp.and;
import com.whatsapp.aus;
import com.whatsapp.hy;
import com.whatsapp.jr;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.m;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.az;
import com.whatsapp.va;
import com.whatsapp.vv;
import java.io.IOException;
import java.io.InputStream;

public class GalleryWallpaperPreview
  extends c
{
  PhotoView n;
  Uri o;
  int p;
  final and q = and.a();
  final g r = g.a();
  final vv s = vv.a();
  private final va t = va.a();
  private final aus u = aus.a();
  
  private BitmapFactory.Options a(InputStream paramInputStream)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    localOptions.inScaled = false;
    BitmapFactory.decodeStream(paramInputStream, null, localOptions);
    float f = Math.min(localOptions.outWidth / getWindowManager().getDefaultDisplay().getWidth(), localOptions.outHeight / getWindowManager().getDefaultDisplay().getHeight());
    int i = 1;
    while (f > 1.0F)
    {
      f /= 2.0F;
      i <<= 1;
    }
    Log.i("gallerywallpaperpreview/wallpaper sample size = " + i);
    localOptions.inJustDecodeBounds = false;
    localOptions.inScaled = true;
    localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    localOptions.inDither = true;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = i;
    return localOptions;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.u.e();
    super.onConfigurationChanged(paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    this.u.e();
    super.onCreate(paramBundle);
    setContentView(2130903236);
    a((Toolbar)findViewById(2131755412));
    paramBundle = i();
    paramBundle.a(true);
    paramBundle.b(new az(android.support.v4.content.b.a(this, 2130840097)));
    if (Build.VERSION.SDK_INT >= 21) {
      findViewById(2131755785).setVisibility(8);
    }
    this.n = ((PhotoView)findViewById(2131755787));
    ((Button)findViewById(2131755789)).setOnClickListener(a.a(this));
    ((Button)findViewById(2131755790)).setOnClickListener(b.a(this));
    paramBundle = (FrameLayout)findViewById(2131755786);
    Object localObject3 = new FrameLayout.LayoutParams(-1, -1);
    j localj = new j(j.a(this.t, "", false));
    localj.e(getResources().getString(2131298183));
    localj.n = m.a();
    Object localObject2 = new j(j.a(this.t, this.t.b(), true));
    ((j)localObject2).e(getResources().getString(2131298181));
    ((j)localObject2).n = m.a();
    ((j)localObject2).d = 5;
    Object localObject1 = new LinearLayout(this);
    ((LinearLayout)localObject1).setBackgroundResource(0);
    ((LinearLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject3 = new a(this, localj);
    ((hy)localObject3).a(true);
    ((hy)localObject3).setEnabled(false);
    ((hy)localObject3).setClickable(false);
    localObject2 = new a(this, (j)localObject2);
    ((hy)localObject2).a(false);
    ((hy)localObject2).setEnabled(false);
    ((hy)localObject2).setClickable(false);
    ((LinearLayout)localObject1).addView((View)localObject3);
    ((LinearLayout)localObject1).addView((View)localObject2);
    ((LinearLayout)localObject1).setClickable(false);
    paramBundle.addView((View)localObject1);
    paramBundle = getIntent().getExtras();
    if (paramBundle != null)
    {
      this.o = ((Uri)paramBundle.getParcelable("output"));
      this.p = paramBundle.getInt("maxFileSize", 0);
    }
    paramBundle = getIntent().getData();
    if (paramBundle == null)
    {
      Log.e("gallerywallpaperpreview/no uri found in intent");
      setResult(0, new Intent().putExtra("io-error", true));
      finish();
      return;
    }
    try
    {
      localObject1 = MediaFileUtils.a(this.q, paramBundle);
      if (localObject1 == null)
      {
        Log.e("gallerywallpaperpreview/bitmap stream is null");
        setResult(0, new Intent().putExtra("io-error", true));
        finish();
        return;
      }
    }
    catch (IOException paramBundle)
    {
      Log.d("gallerywallpaperpreview/io error loading wallpaper", paramBundle);
      setResult(0, new Intent().putExtra("io-error", true));
      finish();
      return;
      localObject2 = a((InputStream)localObject1);
      ((InputStream)localObject1).close();
      localObject2 = BitmapFactory.decodeStream(MediaFileUtils.a(this.q, paramBundle), null, (BitmapFactory.Options)localObject2);
      if ((localObject2 == null) || (((Bitmap)localObject2).getWidth() == 0) || (((Bitmap)localObject2).getHeight() == 0))
      {
        Log.e("gallerywallpaperpreview/failed to load bitmap");
        if (localObject2 != null) {
          ((Bitmap)localObject2).recycle();
        }
        setResult(0, new Intent().putExtra("not-a-image", true));
        finish();
        return;
      }
    }
    catch (OutOfMemoryError paramBundle)
    {
      Log.d("gallerywallpaperpreview/out of memory trying to load wallpaper", paramBundle);
      setResult(0, new Intent().putExtra("error-oom", true));
      finish();
      return;
    }
    localObject1 = MediaFileUtils.b(this.q, paramBundle);
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = new Matrix();
    }
    localObject1 = Bitmap.createBitmap((Bitmap)localObject2, 0, 0, ((Bitmap)localObject2).getWidth(), ((Bitmap)localObject2).getHeight(), paramBundle, true);
    if (localObject2 != localObject1) {
      ((Bitmap)localObject2).recycle();
    }
    float f = Math.max(getWindowManager().getDefaultDisplay().getWidth() / ((Bitmap)localObject1).getWidth(), getWindowManager().getDefaultDisplay().getHeight() / ((Bitmap)localObject1).getHeight());
    if (f <= 1.0F) {}
    for (paramBundle = (Bundle)localObject1;; paramBundle = Bitmap.createScaledBitmap((Bitmap)localObject1, (int)(((Bitmap)localObject1).getWidth() * f), (int)(f * ((Bitmap)localObject1).getHeight()), true))
    {
      if (paramBundle != localObject1) {
        ((Bitmap)localObject1).recycle();
      }
      if ((paramBundle != null) && (paramBundle.getWidth() != 0) && (paramBundle.getHeight() != 0)) {
        break;
      }
      Log.e("gallerywallpaperpreview/failed to load bitmap");
      setResult(0, new Intent().putExtra("not-a-image", true));
      finish();
      return;
      Log.i("gallerywallpaperpreview/scaling image by " + f + "x to fit screen");
    }
    Log.i("gallerywallpaperpreview/wallpaper loaded/w=" + paramBundle.getWidth() + "; h=" + paramBundle.getHeight());
    this.n.a(true);
    this.n.setInitialScaleType$56cf5d5c(PhotoView.c.d);
    this.n.setAllowFullViewCrop(true);
    this.n.a(paramBundle);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    setResult(0);
    finish();
    return true;
  }
  
  final class a
    extends jr
  {
    public a(Context paramContext, j paramj)
    {
      super(paramj);
    }
    
    public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      return false;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/wallpaper/GalleryWallpaperPreview.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */