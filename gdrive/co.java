package com.whatsapp.gdrive;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.m;
import android.support.v7.app.b;
import android.support.v7.app.b.a;

public final class co
  extends m
{
  b aa;
  
  public final void a(Activity paramActivity)
  {
    super.a(paramActivity);
    try
    {
      this.aa = ((b)paramActivity);
      return;
    }
    catch (ClassCastException localClassCastException)
    {
      throw new ClassCastException(paramActivity.toString() + " must implement PromptDialogClickListener");
    }
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = i();
    if (!paramBundle.containsKey("dialog_id")) {
      throw new IllegalStateException("dialog_id should be provided.");
    }
    int i = paramBundle.getInt("dialog_id");
    b.a locala = new b.a(l());
    if (paramBundle.containsKey("title")) {
      locala.a(paramBundle.getString("title"));
    }
    if (paramBundle.containsKey("message")) {
      locala.b(paramBundle.getString("message"));
    }
    if (paramBundle.containsKey("neutral_button")) {
      locala.c(paramBundle.getString("neutral_button"), cp.a(this, i));
    }
    if (paramBundle.containsKey("positive_button")) {
      locala.a(paramBundle.getString("positive_button"), cq.a(this, i));
    }
    if (paramBundle.containsKey("negative_button")) {
      locala.b(paramBundle.getString("negative_button"), cr.a(this, i));
    }
    if ((!paramBundle.containsKey("cancelable")) || (paramBundle.getBoolean("cancelable"))) {}
    for (boolean bool = true;; bool = false)
    {
      locala.a(bool);
      a(bool);
      paramBundle = locala.a();
      paramBundle.setCanceledOnTouchOutside(bool);
      return paramBundle;
    }
  }
  
  public static final class a
  {
    Context a;
    Bundle b;
    
    public a(Context paramContext, int paramInt)
    {
      this.a = paramContext;
      this.b = new Bundle();
      this.b.putInt("dialog_id", paramInt);
    }
    
    public final a a(int paramInt)
    {
      this.b.putString("title", this.a.getString(paramInt));
      return this;
    }
    
    public final a a(String paramString)
    {
      this.b.putString("message", paramString);
      return this;
    }
    
    public final a a(boolean paramBoolean)
    {
      this.b.putBoolean("cancelable", paramBoolean);
      return this;
    }
    
    public final co a()
    {
      co localco = new co();
      localco.f(this.b);
      return localco;
    }
    
    public final a b(int paramInt)
    {
      this.b.putString("positive_button", this.a.getString(paramInt));
      return this;
    }
    
    public final a c(int paramInt)
    {
      this.b.putString("negative_button", this.a.getString(paramInt));
      return this;
    }
  }
  
  public static abstract interface b
  {
    public abstract void f(int paramInt);
    
    public abstract void h(int paramInt);
    
    public abstract void i(int paramInt);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/gdrive/co.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */