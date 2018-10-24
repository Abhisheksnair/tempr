package com.whatsapp.f;

import a.a.a.a.a.a.d;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import com.whatsapp.Conversation;
import com.whatsapp.hh;
import com.whatsapp.k.d.e;
import java.lang.invoke.LambdaForm.Hidden;
import java.util.HashSet;
import java.util.Set;

public final class a
{
  public final Set<a> a = new HashSet();
  public long b = SystemClock.elapsedRealtime();
  public boolean c = false;
  private final d d = new b(this);
  
  public a(final Window paramWindow)
  {
    paramWindow = paramWindow.getDecorView();
    paramWindow.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        a locala = a.this;
        a.d.b();
        if (locala.c) {
          paramWindow.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        for (;;)
        {
          return true;
          a.this.b = SystemClock.elapsedRealtime();
        }
      }
    });
  }
  
  public final void a(c paramc)
  {
    a.d.b();
    a.d.b();
    if (!this.c) {
      paramc.a(this.d);
    }
  }
  
  public static final class a
  {
    public final Conversation a;
    
    public a(Conversation paramConversation)
    {
      this.a = paramConversation;
    }
    
    @LambdaForm.Hidden
    public final void a(long paramLong)
    {
      Object localObject = this.a;
      ((Conversation)localObject).D.a(d.e.i, paramLong);
      Handler localHandler = new Handler(Looper.getMainLooper());
      localObject = Message.obtain(localHandler, hh.a((Conversation)localObject));
      if (Build.VERSION.SDK_INT >= 16) {
        ((Message)localObject).setAsynchronous(true);
      }
      localHandler.sendMessageAtFrontOfQueue((Message)localObject);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */