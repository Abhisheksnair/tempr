package com.whatsapp.gallerypicker;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.r;
import android.support.v4.app.w;
import android.support.v4.content.b;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.whatsapp.aoa;
import com.whatsapp.nh;
import com.whatsapp.pv;
import com.whatsapp.util.Log;
import com.whatsapp.util.az;

public class MediaPicker
  extends nh
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Fragment localFragment = j_().a(2131755340);
    if (localFragment != null) {
      localFragment.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("mediapicker/create");
    b(5);
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = getWindow();
      ((Window)localObject).addFlags(Integer.MIN_VALUE);
      ((Window)localObject).clearFlags(67108864);
      ((Window)localObject).requestFeature(13);
      ((Window)localObject).requestFeature(12);
      Transition localTransition = TransitionInflater.from(this).inflateTransition(17760259);
      localTransition.excludeTarget(16908335, true);
      localTransition.excludeTarget(16908336, true);
      ((Window)localObject).setEnterTransition(localTransition);
      localTransition = TransitionInflater.from(this).inflateTransition(17760258);
      localTransition.excludeTarget(16908335, true);
      localTransition.excludeTarget(16908336, true);
      ((Window)localObject).setExitTransition(localTransition);
      localTransition = TransitionInflater.from(this).inflateTransition(17760258);
      localTransition.excludeTarget(16908335, true);
      localTransition.excludeTarget(16908336, true);
      ((Window)localObject).setReturnTransition(localTransition);
      localTransition = TransitionInflater.from(this).inflateTransition(17760257);
      ((Window)localObject).setSharedElementEnterTransition(localTransition);
      ((Window)localObject).setSharedElementExitTransition(localTransition);
      o_();
    }
    super.onCreate(paramBundle);
    i().a(true);
    if (!this.aq.d()) {
      i().b(new az(b.a(this, 2130840097)));
    }
    Object localObject = new FrameLayout(this);
    ((FrameLayout)localObject).setId(2131755340);
    if (paramBundle == null)
    {
      paramBundle = new ae();
      j_().a().a(((FrameLayout)localObject).getId(), paramBundle).d();
      paramBundle = new View(this);
      paramBundle.setBackgroundColor(b.c(this, 2131624022));
      paramBundle.setLayoutParams(new FrameLayout.LayoutParams(-1, (int)Math.ceil(aoa.a().a / 2.0F)));
      ((FrameLayout)localObject).addView(paramBundle);
    }
    setContentView((View)localObject);
  }
  
  public void onDestroy()
  {
    Log.i("mediapicker/destroy");
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      android.support.v4.app.a.c(this);
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public void onPause()
  {
    Log.i("mediapicker/pause");
    super.onPause();
  }
  
  public void onResume()
  {
    Log.i("mediapicker/resume");
    super.onResume();
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gallerypicker/MediaPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */