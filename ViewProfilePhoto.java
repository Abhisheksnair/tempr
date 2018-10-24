package com.whatsapp;

import a.a.a.a.a.a.d;
import a.a.a.a.d;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ab;
import android.support.v4.view.o;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionValues;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class ViewProfilePhoto
  extends nh
{
  private static final String n = au.b() + ".intent.action.SAVE_PHOTO";
  private cs o;
  private final Handler p = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      paramAnonymousMessage = u.a();
      if (ViewProfilePhoto.a(ViewProfilePhoto.this).d()) {}
      for (int i = 2131296790;; i = 2131296792)
      {
        pv.a(paramAnonymousMessage, i, 0);
        ViewProfilePhoto.this.findViewById(2131755238).setVisibility(8);
        return;
      }
    }
  };
  private final va q = va.a();
  private final oz r = oz.a();
  private final e s = e.a();
  private final dh t = dh.a();
  private final dh.a u = new dh.a()
  {
    public final void a()
    {
      ViewProfilePhoto.a(ViewProfilePhoto.this, ViewProfilePhoto.b(ViewProfilePhoto.this).d(ViewProfilePhoto.a(ViewProfilePhoto.this).t));
      if (ViewProfilePhoto.a(ViewProfilePhoto.this).d())
      {
        ViewProfilePhoto.this.setTitle(2131297011);
        return;
      }
      ViewProfilePhoto.this.f(ViewProfilePhoto.a(ViewProfilePhoto.this).a(ViewProfilePhoto.this));
    }
    
    protected final void a(String paramAnonymousString)
    {
      ViewProfilePhoto.a(ViewProfilePhoto.this, ViewProfilePhoto.b(ViewProfilePhoto.this).d(ViewProfilePhoto.a(ViewProfilePhoto.this).t));
      if (!ViewProfilePhoto.a(ViewProfilePhoto.this).d()) {
        ViewProfilePhoto.this.f(ViewProfilePhoto.a(ViewProfilePhoto.this).a(ViewProfilePhoto.this));
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      ViewProfilePhoto.a(ViewProfilePhoto.this, ViewProfilePhoto.b(ViewProfilePhoto.this).d(ViewProfilePhoto.a(ViewProfilePhoto.this).t));
      if (paramAnonymousString.equals(ViewProfilePhoto.a(ViewProfilePhoto.this).t))
      {
        Log.i("viewprofilephoto/onprofilephotochanged photo_full_id:" + ViewProfilePhoto.a(ViewProfilePhoto.this).l);
        boolean bool = ViewProfilePhoto.this.aP.b(Environment.getExternalStorageState());
        ViewProfilePhoto.c(ViewProfilePhoto.this).removeMessages(0);
        if ((bool) && (ViewProfilePhoto.a(ViewProfilePhoto.this).l == 0))
        {
          ViewProfilePhoto.this.aN.a(ViewProfilePhoto.a(ViewProfilePhoto.this).t, ViewProfilePhoto.a(ViewProfilePhoto.this).l, 1);
          ViewProfilePhoto.c(ViewProfilePhoto.this).sendEmptyMessageDelayed(0, 32000L);
        }
        ViewProfilePhoto.d(ViewProfilePhoto.this);
        ViewProfilePhoto.this.invalidateOptionsMenu();
      }
    }
  };
  
  private void l()
  {
    localObject2 = findViewById(2131755238);
    ImageView localImageView = (ImageView)findViewById(2131755467);
    localObject3 = (TextView)findViewById(2131755691);
    if (ach.b(this.o.t))
    {
      ((View)localObject2).setVisibility(0);
      localImageView.setVisibility(8);
      ((TextView)localObject3).setVisibility(8);
    }
    for (;;)
    {
      return;
      InputStream localInputStream = this.o.b(true);
      if (localInputStream == null) {
        try
        {
          localImageView.setVisibility(8);
          ((View)localObject2).setVisibility(8);
          ((TextView)localObject3).setVisibility(0);
          if (this.o.d()) {
            ((TextView)localObject3).setText(2131297290);
          }
          while (localInputStream != null)
          {
            try
            {
              localInputStream.close();
              return;
            }
            catch (IOException localIOException1)
            {
              return;
            }
            ((TextView)localObject3).setText(2131297304);
          }
          try
          {
            localIOException1.close();
            throw ((Throwable)localObject1);
            ((ImageView)localObject1).setVisibility(0);
            ((TextView)localObject3).setVisibility(8);
            if (this.o.l == 0) {
              ((View)localObject2).setVisibility(0);
            }
            for (;;)
            {
              localObject2 = new BitmapFactory.Options();
              ((BitmapFactory.Options)localObject2).inDither = true;
              ((BitmapFactory.Options)localObject2).inInputShareable = true;
              ((BitmapFactory.Options)localObject2).inPurgeable = true;
              try
              {
                localObject3 = d.a(localIOException1);
                ((ImageView)localObject1).setImageBitmap(BitmapFactory.decodeByteArray((byte[])localObject3, 0, localObject3.length, (BitmapFactory.Options)localObject2));
              }
              catch (IOException localIOException4)
              {
                Log.e(localIOException4);
              }
              ((View)localObject2).setVisibility(8);
            }
            if (localIOException1 == null) {
              continue;
            }
            try
            {
              localIOException1.close();
              return;
            }
            catch (IOException localIOException2) {}
          }
          catch (IOException localIOException3)
          {
            for (;;) {}
          }
        }
        finally
        {
          if (localIOException1 == null) {}
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        if ((paramIntent != null) && (paramIntent.getBooleanExtra("is_reset", false)))
        {
          this.t.c(this.o.t);
          this.aO.a(this.o);
          finish();
          return;
        }
        this.aO.a(this, 13, paramIntent);
        return;
        if (!this.aO.b().delete()) {
          Log.w("viewprofilephoto/failed-delete-file" + this.aO.b().getAbsolutePath());
        }
        if (paramInt2 != -1) {
          break;
        }
        this.t.c(this.o.t);
      } while (!this.aO.a(this, this.o));
      l();
      return;
    } while ((paramInt2 != 0) || (paramIntent == null));
    this.aO.a(this, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      getWindow().requestFeature(12);
      getWindow().requestFeature(13);
      localObject2 = new Fade()
      {
        @TargetApi(19)
        public final void captureStartValues(TransitionValues paramAnonymousTransitionValues)
        {
          super.captureStartValues(paramAnonymousTransitionValues);
          if (this.a != 0.0F) {
            paramAnonymousTransitionValues.values.put("android:fade:transitionAlpha", Float.valueOf(this.a));
          }
        }
      };
      Fade localFade = new Fade();
      ((Transition)localObject2).excludeTarget(16908335, true);
      ((Transition)localObject2).excludeTarget(16908336, true);
      localFade.excludeTarget(16908335, true);
      localFade.excludeTarget(16908336, true);
      localObject1 = getWindow();
      ((Window)localObject1).setEnterTransition((Transition)localObject2);
      ((Window)localObject1).setExitTransition(localFade);
      if (getIntent().getBooleanExtra("circular_transition", false))
      {
        localObject2 = new com.whatsapp.n.a(true, false);
        ((Transition)localObject2).addTarget(getString(2131298269));
        ((Window)localObject1).setSharedElementEnterTransition((Transition)localObject2);
        localObject2 = new com.whatsapp.n.a(false, true);
        ((Transition)localObject2).addTarget(getString(2131298269));
        ((Window)localObject1).setSharedElementReturnTransition((Transition)localObject2);
      }
      if (getIntent().hasExtra("circular_return_name"))
      {
        localObject2 = new com.whatsapp.n.a(false, false);
        ((Transition)localObject2).addTarget(getIntent().getStringExtra("circular_return_name"));
        ((Window)localObject1).setSharedElementEnterTransition((Transition)localObject2);
        localObject2 = new com.whatsapp.n.a(false, true);
        ((Transition)localObject2).addTarget(getIntent().getStringExtra("circular_return_name"));
        ((Window)localObject1).setSharedElementReturnTransition((Transition)localObject2);
      }
    }
    super.onCreate(paramBundle);
    Log.i("viewprofilephoto/create");
    ((android.support.v7.app.a)a.d.a(i())).a(true);
    setContentView(2130903395);
    paramBundle = getIntent().getStringExtra("jid");
    this.o = this.s.d(paramBundle);
    Log.i("viewprofilephoto/create " + paramBundle + " photo_full_id:" + this.o.l);
    this.t.registerObserver(this.u);
    Object localObject1 = this.q.c();
    if (localObject1 == null)
    {
      Log.i("viewprofilephoto/create/no-me");
      this.aq.a("conversations bounce to main");
      startActivity(new Intent(this, Main.class));
      finish();
      return;
    }
    i().a(true);
    if (this.o.d())
    {
      setTitle(2131297011);
      if (!paramBundle.equals(((cs)localObject1).t)) {
        break label638;
      }
      if ((this.o.l > 0) && (!this.o.b().exists()))
      {
        this.o.l = 0;
        this.aN.a(this.o.t, this.o.l, 1);
        this.p.sendEmptyMessageDelayed(0, 32000L);
      }
    }
    for (;;)
    {
      localObject2 = (ImageView)findViewById(2131755467);
      localObject1 = getIntent().getStringExtra("circular_return_name");
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null) {
        paramBundle = getString(2131298269);
      }
      ab.a((View)localObject2, paramBundle);
      ((ImageView)localObject2).setImageBitmap(this.o.a(getResources().getDimensionPixelSize(2131362090), getResources().getDimensionPixelSize(2131361833), true));
      if (Build.VERSION.SDK_INT == 10) {
        ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      }
      l();
      return;
      if (paramBundle.equals(((cs)localObject1).t))
      {
        setTitle(2131297490);
        break;
      }
      f(this.o.a(this));
      break;
      label638:
      if (this.aI.a(new vv.a()
      {
        public final void a()
        {
          ViewProfilePhoto.this.aq.a(ViewProfilePhoto.this);
        }
        
        public final void b()
        {
          ViewProfilePhoto.this.aq.a(ViewProfilePhoto.this);
        }
        
        public final void c()
        {
          RequestPermissionActivity.b(ViewProfilePhoto.this, 2131297450, 2131297419);
        }
        
        public final void d()
        {
          RequestPermissionActivity.b(ViewProfilePhoto.this, 2131297435, 2131297434);
        }
      }))
      {
        if ((this.o.l > 0) && (!this.o.b().exists())) {
          this.o.l = 0;
        }
        this.aN.a(this.o.t, this.o.l, 1);
        if (this.o.l == 0) {
          this.p.sendEmptyMessageDelayed(0, 32000L);
        }
      }
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if ((this.o.d()) || (this.o.equals(this.q.c()))) {
      o.a(paramMenu.add(0, 0, 0, 2131296698).setIcon(2130840059), 2);
    }
    o.a(paramMenu.add(0, 1, 0, 2131297833).setIcon(2130840077), 2);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("viewprofilephoto/destroy");
    this.p.removeMessages(0);
    this.t.unregisterObserver(this.u);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    Object localObject;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onOptionsItemSelected(paramMenuItem);
    case 0: 
      this.aO.a(this, this.o, 12);
      return true;
    case 1: 
      Intent localIntent = new Intent("android.intent.action.SEND");
      localIntent.setType("image/*");
      localObject = this.r;
      if (this.o.equals(this.q.c())) {}
      for (paramMenuItem = "me.jpg";; paramMenuItem = "photo.jpg")
      {
        paramMenuItem = ((oz)localObject).a(paramMenuItem);
        try
        {
          localObject = new FileInputStream(this.o.b());
        }
        finally
        {
          localObject = null;
          a.d.a((Closeable)localObject);
        }
        for (;;)
        {
          try
          {
            MediaFileUtils.a((InputStream)localObject, new FileOutputStream(paramMenuItem));
          }
          finally
          {
            break;
          }
          try
          {
            a.d.a((Closeable)localObject);
            localIntent.putExtra("android.intent.extra.STREAM", d.a(this, paramMenuItem));
            localObject = Intent.createChooser(localIntent, null);
            localIntent = new Intent(n, null);
            localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(paramMenuItem));
            localIntent.putExtra("name", this.o.a(this));
            ((Intent)localObject).putExtra("android.intent.extra.INITIAL_INTENTS", new Intent[] { localIntent });
            startActivity((Intent)localObject);
            return true;
          }
          catch (IOException paramMenuItem)
          {
            Log.e(paramMenuItem);
            pv.a(getApplicationContext(), 2131297457, 1);
            return true;
          }
        }
      }
    }
    android.support.v4.app.a.c(this);
    return true;
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (paramMenu.size() == 0) {
      return false;
    }
    paramMenu.findItem(1).setVisible(this.o.b().exists());
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public static class SavePhoto
    extends Activity
  {
    private final pv a = pv.a();
    private final oz b = oz.a();
    
    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      paramBundle = (Uri)getIntent().getParcelableExtra("android.intent.extra.STREAM");
      Object localObject = getIntent().getStringExtra("name").replaceAll("[?:\\/*\"<>|]", "");
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US);
      oz localoz = this.b;
      if (!localoz.l) {
        localoz.j();
      }
      localObject = new File(oz.c(localoz.j), (String)localObject + " " + localSimpleDateFormat.format(new Date()) + ".jpg");
      try
      {
        MediaFileUtils.a(new File(paramBundle.getPath()), (File)localObject);
        MediaFileUtils.a(this, Uri.fromFile((File)localObject));
        pv.a(getApplicationContext(), 2131297463, 0);
        finish();
        return;
      }
      catch (IOException paramBundle)
      {
        for (;;)
        {
          Log.d("viewprofilephoto/save/failed", paramBundle);
          pv.a(getApplicationContext(), 2131297457, 1);
        }
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ViewProfilePhoto.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */