package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.format.Formatter;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.az;
import java.io.File;

public final class je
  extends jm
{
  private static Handler ag;
  private final TextView O = (TextView)findViewById(2131755580);
  private final ConversationRowVideo.RowVideoView P = (ConversationRowVideo.RowVideoView)findViewById(2131755327);
  private final TextView Q = (TextView)findViewById(2131755493);
  private final CircularProgressBar R = (CircularProgressBar)findViewById(2131755238);
  private final ImageView S = (ImageView)findViewById(2131755613);
  private final View aa = findViewById(2131755579);
  private final TextEmojiLabel ab = (TextEmojiLabel)findViewById(2131755436);
  private final View ac;
  private final ag ad = ag.a();
  private ag.a ae = new ag.a()
  {
    public final int a()
    {
      View localView = ((Activity)je.this.getContext()).getWindow().getDecorView();
      return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
    }
    
    public final void a(View paramAnonymousView)
    {
      je.a(je.this).setBackgroundColor(-7829368);
    }
    
    public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
    {
      if (paramAnonymousBitmap != null)
      {
        je.a(je.this).setImageDrawable(new BitmapDrawable(je.this.getContext().getResources(), paramAnonymousBitmap));
        je.a(je.this).a(paramAnonymousBitmap.getWidth(), paramAnonymousBitmap.getHeight(), false);
        return;
      }
      je.a(je.this).setImageDrawable(new ColorDrawable(b.c(je.this.getContext(), 2131624003)));
    }
  };
  private a af;
  
  public je(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    this.ab.setLinkHandler(new th());
    this.ac = findViewById(2131755614);
    this.R.setMax(100);
    this.R.setProgressBarBackgroundColor(0);
    if (ag == null) {
      int i = Build.VERSION.SDK_INT;
    }
    c(true);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.a.b();
    this.Q.setVisibility(8);
    this.P.setKeepRatio(this.d);
    this.P.setFullWidth(this.d);
    ab.a(this.P, b(this.a));
    ab.a(this.n, c(this.a));
    if (this.o != null) {
      ab.a(this.o, d(this.a));
    }
    int i;
    if (this.d)
    {
      i = ag.a(this.a, aoa.a().l);
      ConversationRowVideo.RowVideoView localRowVideoView = this.P;
      int j = aoa.a().l;
      if (i > 0) {
        localRowVideoView.a(j, i, true);
      }
    }
    else
    {
      if (!((MediaData)localObject).transferring) {
        break label454;
      }
      f();
      if (paramBoolean) {
        break label449;
      }
      paramBoolean = true;
      label153:
      a(true, paramBoolean, this.aa, this.R, this.S, this.O);
      this.P.setVisibility(0);
      this.P.setOnClickListener(null);
      this.O.setOnClickListener(this.V);
      this.R.setOnClickListener(this.V);
      label212:
      g();
      this.P.setOnLongClickListener(this.u);
      this.P.setFrameDrawable(ConversationRowImage.O);
      this.ad.a(this.a, this.P, this.ae);
      if (ag != null)
      {
        if (this.af != null)
        {
          ag.removeCallbacks(this.af);
          this.af.a();
        }
        this.af = new a((MediaData)localObject);
        ag.postDelayed(this.af, 2000L);
      }
      if (this.a.w == 0) {
        this.a.w = MediaFileUtils.b(((MediaData)localObject).file);
      }
      if (this.a.w == 0) {
        break label703;
      }
      localObject = DateUtils.formatElapsedTime(this.a.w);
      label362:
      this.Q.setText((CharSequence)localObject);
      this.Q.setVisibility(0);
      if (!this.l.d()) {
        break label721;
      }
      this.Q.setCompoundDrawablesWithIntrinsicBounds(2130840345, 0, 0, 0);
    }
    for (;;)
    {
      if (this.n != null) {
        this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
      a(this.ac, this.ab);
      return;
      i = aoa.a().l * 9 / 16;
      break;
      label449:
      paramBoolean = false;
      break label153;
      label454:
      if (((MediaData)localObject).transferred)
      {
        e();
        this.P.setVisibility(0);
        a(false, false, this.aa, this.R, this.S, this.O);
        this.O.setVisibility(8);
        this.S.setVisibility(0);
        this.S.setImageResource(2130840269);
        this.S.setContentDescription(getResources().getString(2131297474));
        this.S.setOnClickListener(this.W);
        this.O.setOnClickListener(this.W);
        this.P.setOnClickListener(this.W);
        break label212;
      }
      this.O.setText(Formatter.formatShortFileSize(u.a(), this.a.t));
      this.O.setContentDescription(getResources().getString(2131296368));
      this.O.setCompoundDrawablesWithIntrinsicBounds(2130837663, 0, 0, 0);
      this.O.setOnClickListener(this.T);
      this.P.setOnClickListener(this.T);
      f();
      this.O.setVisibility(0);
      this.S.setVisibility(8);
      if (!paramBoolean) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        a(false, paramBoolean, this.aa, this.R, this.S, this.O);
        break;
      }
      label703:
      localObject = Formatter.formatShortFileSize(u.a(), this.a.t);
      break label362;
      label721:
      this.Q.setCompoundDrawablesWithIntrinsicBounds(null, null, new az(getContext().getResources().getDrawable(2130840345)), null);
    }
  }
  
  protected final int a(int paramInt)
  {
    int j;
    if (!TextUtils.isEmpty(this.a.z))
    {
      j = super.a(paramInt);
      return j;
    }
    int i;
    if (s.a(paramInt, 13) >= 0) {
      i = 2130840358;
    }
    for (;;)
    {
      j = i;
      if (!av.d()) {
        break;
      }
      j = i;
      if (paramInt != 7) {
        break;
      }
      return 2130840370;
      if (s.a(paramInt, 5) >= 0) {
        i = 2130840362;
      } else if (s.a(paramInt, 4) == 0) {
        i = 2130840360;
      } else {
        i = 2130840370;
      }
    }
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj != this.a) {}
    for (boolean bool = true;; bool = false)
    {
      super.a(paramj, paramBoolean);
      if ((paramBoolean) || (bool)) {
        c(bool);
      }
      return;
    }
  }
  
  protected final boolean a()
  {
    return false;
  }
  
  protected final void b()
  {
    int i = 1;
    Object localObject1 = this.a.b();
    if (!((MediaData)localObject1).transferred) {}
    do
    {
      return;
      if (((MediaData)localObject1).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)
      {
        this.l.b(getContext(), 2131296830, 1);
        return;
      }
      boolean bool = false;
      if (((MediaData)localObject1).file != null) {
        bool = new File(Uri.fromFile(((MediaData)localObject1).file).getPath()).exists();
      }
      Log.i("viewmessage/ from_me:" + this.a.e.b + " type:" + this.a.s + " name:" + this.a.y + " url:" + MediaFileUtils.a(this.a.p) + " file:" + ((MediaData)localObject1).file + " progress:" + ((MediaData)localObject1).progress + " transferred:" + ((MediaData)localObject1).transferred + " transferring:" + ((MediaData)localObject1).transferring + " fileSize:" + ((MediaData)localObject1).fileSize + " media_size:" + this.a.t + " timestamp:" + this.a.n);
      if (bool) {
        break label370;
      }
      Log.w("viewmessage/ no file");
      if (!this.c) {
        break;
      }
      localObject1 = getContext();
    } while (!(localObject1 instanceof nh));
    this.l.a((nh)localObject1);
    return;
    localObject1 = new Intent(getContext(), MediaGallery.class);
    ((Intent)localObject1).putExtra("pos", -1);
    ((Intent)localObject1).putExtra("alert", true);
    ((Intent)localObject1).putExtra("jid", this.a.e.a);
    ((Intent)localObject1).putExtra("key", this.a.e.hashCode());
    getContext().startActivity((Intent)localObject1);
    return;
    label370:
    if (this.a.s == 3)
    {
      yx.i();
      if (this.c)
      {
        if ((Build.VERSION.SDK_INT >= 16) && (aic.T))
        {
          localObject1 = MediaView.a(this.a, this.a.e.a, getContext(), 3);
          ((Intent)localObject1).putExtra("nogallery", true);
          getContext().startActivity((Intent)localObject1);
          return;
        }
        Object localObject2 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject2).setDataAndType(MediaProvider.a(this.a), "video/*");
        ((Intent)localObject2).setFlags(1);
        pv.a(getContext(), (Intent)localObject2);
        localObject2 = getContext();
        if (this.a.e.b) {
          i = 3;
        }
        pb.a((Context)localObject2, i, 3, this.a.w, ((MediaData)localObject1).file);
        return;
      }
      localObject1 = MediaView.a(this.a, this.a.e.a, getContext(), 1);
      getContext().startActivity((Intent)localObject1);
      return;
    }
    localObject1 = MediaView.a(this.a, this.a.e.a, getContext());
    ((Intent)localObject1).putExtra("nogallery", this.c);
    getContext().startActivity((Intent)localObject1);
  }
  
  public final void g()
  {
    int i = a(this.R, this.a.b());
    CircularProgressBar localCircularProgressBar = this.R;
    if (i == 0) {}
    for (i = b.c(getContext(), 2131624070);; i = b.c(getContext(), 2131624069))
    {
      localCircularProgressBar.setProgressBarColor(i);
      return;
    }
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903154;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903154;
  }
  
  final int getMainChildMaxWidth()
  {
    View localView = ((Activity)getContext()).getWindow().getDecorView();
    return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
  }
  
  protected final int getOutgoingLayoutId()
  {
    throw new IllegalStateException("this row type does not support outgoing messages");
  }
  
  protected final int getStarDrawable()
  {
    if (TextUtils.isEmpty(this.a.z)) {
      return 2130840366;
    }
    return super.getStarDrawable();
  }
  
  public final void i()
  {
    c(false);
    super.i();
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((ag != null) && (this.af == null))
    {
      this.af = new a(this.a.b());
      ag.postDelayed(this.af, 2000L);
    }
  }
  
  final class a
    implements Runnable
  {
    MediaData a;
    long b = 1000000L;
    Drawable c;
    long d;
    
    a(MediaData paramMediaData)
    {
      this.a = paramMediaData;
    }
    
    final void a()
    {
      je.p().post(new jg(this));
      je.this.post(new jh(this));
    }
    
    public final void run()
    {
      if ((this.a == null) || (this.a != je.this.a.b()) || (!je.this.isShown()) || (je.b(je.this) != this) || (this.a.file == null) || (!this.a.file.exists()))
      {
        a();
        return;
      }
      long l = je.this.getDrawingTime();
      if (this.d == l)
      {
        a();
        return;
      }
      this.d = l;
      int n = 0;
      int i1 = 0;
      int m = 0;
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      i = n;
      j = i1;
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(this.a.file.getAbsolutePath());
          i = n;
          j = i1;
          Bitmap localBitmap = localMediaMetadataRetriever.getFrameAtTime(this.b);
          i = n;
          j = i1;
          l = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
          k = m;
          if (l > 2000L)
          {
            i = n;
            j = i1;
            if (this.b <= l * 1000L) {
              continue;
            }
            i = n;
            j = i1;
            this.b = 0L;
            k = m;
            if (localBitmap != null)
            {
              k = m;
              i = n;
              j = i1;
              if (this.a == je.this.a.b())
              {
                k = m;
                i = n;
                j = i1;
                if (je.this.isShown())
                {
                  i = 1;
                  j = 1;
                  k = 1;
                  je.this.post(new jf(this, localBitmap));
                }
              }
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("videopreview/getvideothumb" + localException.toString());
          int k = i;
          continue;
          a();
          return;
        }
        catch (NoSuchMethodError localNoSuchMethodError)
        {
          i = j;
          continue;
        }
        localMediaMetadataRetriever.release();
        if (k == 0) {
          continue;
        }
        je.p().postDelayed(this, 2000L);
        return;
        i = n;
        j = i1;
        this.b += 1000000L;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/je.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */