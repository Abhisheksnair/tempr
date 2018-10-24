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
import android.text.TextUtils;
import android.text.format.Formatter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.whatsapp.data.cs;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import java.io.File;
import java.util.Queue;

public final class iy
  extends jm
  implements ss.b<j.b>, ss.c
{
  private static Handler an;
  final ss<j.b> O;
  private final TextView P;
  private final ConversationRowVideo.RowVideoView Q;
  private final ViewGroup R;
  private final TextView S;
  private final CircularProgressBar aa;
  private final ImageView ab;
  private final View ac;
  private final TextEmojiLabel ad;
  private final View ae;
  private final ImageView af;
  private final at ag = new at()
  {
    public final void a(View paramAnonymousView)
    {
      iy.this.T.a(paramAnonymousView);
      paramAnonymousView = iy.this.getRowsContainer();
      if (paramAnonymousView != null) {
        paramAnonymousView.b(iy.this.a.e);
      }
    }
  };
  private final oz ah;
  private final ag ai;
  private int aj;
  private int ak;
  private ag.a al;
  private a am;
  
  public iy(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (isInEditMode())
    {
      paramj = null;
      this.ah = paramj;
      if (!isInEditMode()) {
        break label287;
      }
      paramj = null;
      label41:
      this.ai = paramj;
      this.al = new ag.a()
      {
        public final int a()
        {
          View localView = ((Activity)iy.this.getContext()).getWindow().getDecorView();
          return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
        }
        
        public final void a(View paramAnonymousView)
        {
          iy.a(iy.this).setImageDrawable(new ColorDrawable(-7829368));
        }
        
        public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
        {
          if (paramAnonymousBitmap != null)
          {
            iy.a(iy.this).setImageDrawable(new BitmapDrawable(iy.this.getContext().getResources(), paramAnonymousBitmap));
            if (iy.b(iy.this) != null)
            {
              int i = paramAnonymousBitmap.getWidth();
              int j = paramAnonymousBitmap.getHeight();
              if ((iy.c(iy.this) <= 0) || (iy.c(iy.this) <= 0))
              {
                iy.a(iy.this, j);
                iy.b(iy.this, i);
              }
              iy.b(iy.this).a(i, j);
              iy.a(iy.this).a(i, j, false);
            }
            return;
          }
          iy.a(iy.this).setImageDrawable(new ColorDrawable(b.c(iy.this.getContext(), 2131624003)));
        }
      };
      this.P = ((TextView)findViewById(2131755580));
      this.Q = ((ConversationRowVideo.RowVideoView)findViewById(2131755327));
      this.aa = ((CircularProgressBar)findViewById(2131755238));
      this.S = ((TextView)findViewById(2131755493));
      this.ab = ((ImageView)findViewById(2131755613));
      this.ac = findViewById(2131755579);
      this.ad = ((TextEmojiLabel)findViewById(2131755436));
      this.ad.setLinkHandler(new th());
      this.R = ((ViewGroup)findViewById(2131755611));
      this.ae = findViewById(2131755614);
      this.af = ((ImageView)findViewById(2131755612));
      if (Build.VERSION.SDK_INT < 16) {
        break label294;
      }
      this.O = new ss(paramContext, this, this);
      paramContext = new FrameLayout.LayoutParams(-1, -1);
      this.O.setLayoutParams(paramContext);
      this.R.addView(this.O);
    }
    for (;;)
    {
      this.aa.setMax(100);
      this.aa.setProgressBarBackgroundColor(0);
      if (an == null) {
        int i = Build.VERSION.SDK_INT;
      }
      c(true);
      return;
      paramj = oz.a();
      break;
      label287:
      paramj = ag.a();
      break label41;
      label294:
      this.O = null;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    Log.d("conversation/row/gif/fillView for " + this.a.e + " is-new = " + paramBoolean);
    MediaData localMediaData = this.a.b();
    this.P.setVisibility(0);
    this.S.setVisibility(8);
    this.R.setVisibility(8);
    Object localObject1;
    Object localObject5;
    int i;
    if (this.O != null)
    {
      this.O.setVisibility(4);
      this.O.a();
      localObject1 = this.O;
      ??? = this.a.e;
      localObject5 = localMediaData.file;
      boolean bool = localMediaData.transferred;
      int j = localMediaData.width;
      int k = localMediaData.height;
      Log.d("in/place/video/view/reset from " + ((ss)localObject1).f + " to " + ???);
      if (???.equals(((ss)localObject1).f)) {
        break label803;
      }
      i = 1;
      ((ss)localObject1).f = ???;
      ((ss)localObject1).g = bool;
      ((ss)localObject1).c();
      ss.a.post(sx.a((ss)localObject1));
      ((ss)localObject1).l = false;
      if (((ss)localObject1).n != null) {
        ((ss)localObject1).n.q();
      }
      if (i != 0)
      {
        ((ss)localObject1).i = j;
        ((ss)localObject1).j = k;
      }
      if (((ss)localObject1).g)
      {
        if (i != 0) {
          ((ss)localObject1).forceLayout();
        }
        localObject5 = new ss.2((ss)localObject1, (File)localObject5, ???);
      }
    }
    for (;;)
    {
      synchronized (((ss)localObject1).e)
      {
        if (ss.a.post((Runnable)localObject5)) {
          ((ss)localObject1).e.add(localObject5);
        }
        this.Q.setKeepRatio(true);
        if (!localMediaData.transferring) {
          break label840;
        }
        f();
        this.P.setVisibility(8);
        if (!paramBoolean)
        {
          paramBoolean = true;
          a(true, paramBoolean, this.ac, this.aa, this.ab, this.P);
          this.Q.setVisibility(0);
          if (!this.a.e.b) {
            break label821;
          }
          this.Q.setOnClickListener(this.W);
          this.R.setOnClickListener(this.W);
          this.P.setOnClickListener(this.V);
          this.aa.setOnClickListener(this.V);
          g();
          this.Q.setOnLongClickListener(this.u);
          this.R.setOnLongClickListener(this.u);
          ??? = this.Q;
          if (!this.a.e.b) {
            break label1283;
          }
          localObject1 = ConversationRowImage.P;
          ((ConversationRowVideo.RowVideoView)???).setFrameDrawable((Drawable)localObject1);
          i = ag.a(this.a, aoa.a().l);
          if (i <= 0) {
            break label1291;
          }
          this.ak = i;
          this.aj = aoa.a().l;
          if (this.O != null) {
            this.O.a(this.aj, this.ak);
          }
          this.Q.a(this.aj, this.ak, true);
          this.ai.a(this.a, this.Q, this.al);
          if (an != null)
          {
            if (this.am != null)
            {
              an.removeCallbacks(this.am);
              this.am.a();
            }
            this.am = new a(localMediaData);
            an.postDelayed(this.am, 2000L);
          }
          if (this.a.w == 0) {
            this.a.w = MediaFileUtils.b(localMediaData.file);
          }
          this.S.setText("");
          this.S.setVisibility(0);
          s();
          if (this.O != null) {
            break label1320;
          }
          i = 2130840344;
          if ((!this.l.d()) && (i != 0)) {
            break label1325;
          }
          this.S.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
          if (this.n != null)
          {
            if ((!this.a.E) || (!this.a.e.b) || (cs.e(this.a.e.a))) {
              break label1358;
            }
            this.n.setCompoundDrawablesWithIntrinsicBounds(2130837657, 0, 0, 0);
          }
          a(this.ae, this.ad);
          return;
          label803:
          i = 0;
        }
      }
      paramBoolean = false;
      continue;
      label821:
      this.Q.setOnClickListener(null);
      this.R.setOnClickListener(null);
      continue;
      label840:
      Object localObject3;
      if ((localMediaData.transferred) || ((this.a.E) && (this.a.e.b) && (!j.b(this.a.e.a))))
      {
        e();
        a(false, false, this.ac, this.aa, this.ab, this.P);
        this.ab.setVisibility(0);
        this.ab.setImageResource(2130840176);
        this.ab.setContentDescription(getResources().getString(2131297473));
        this.P.setVisibility(8);
        if (this.O != null)
        {
          this.R.setVisibility(0);
          this.O.setVisibility(0);
          this.R.setOnClickListener(this.W);
        }
        this.Q.setVisibility(0);
        localObject3 = iz.a(this);
        this.P.setOnClickListener((View.OnClickListener)localObject3);
        this.Q.setOnClickListener((View.OnClickListener)localObject3);
        localObject3 = getRowsContainer();
        if ((localObject3 != null) && (this.O != null) && (((jz)localObject3).a(this.a.e))) {
          this.O.b();
        }
      }
      else
      {
        this.ab.setVisibility(8);
        if ((this.a.e.b) && ((localMediaData.file != null) || (this.a.y != null)))
        {
          this.P.setText(2131297619);
          this.P.setContentDescription(getResources().getString(2131297619));
          this.P.setCompoundDrawablesWithIntrinsicBounds(2130837714, 0, 0, 0);
          this.P.setOnClickListener(this.U);
          this.Q.setOnClickListener(this.W);
          label1169:
          f();
          if (paramBoolean) {
            break label1278;
          }
        }
        label1278:
        for (paramBoolean = true;; paramBoolean = false)
        {
          a(false, paramBoolean, this.ac, this.aa, this.ab, this.P);
          break;
          this.P.setText(Formatter.formatShortFileSize(u.a(), this.a.t));
          this.P.setContentDescription(getResources().getString(2131296368));
          this.P.setCompoundDrawablesWithIntrinsicBounds(2130837663, 0, 0, 0);
          this.P.setOnClickListener(this.ag);
          this.Q.setOnClickListener(this.ag);
          break label1169;
        }
        label1283:
        localObject3 = ConversationRowImage.O;
        continue;
        label1291:
        this.ak = (aoa.a().l * 9 / 16);
        this.aj = aoa.a().l;
        continue;
        label1320:
        i = 0;
        continue;
        label1325:
        this.S.setCompoundDrawablesWithIntrinsicBounds(null, null, new az(getContext().getResources().getDrawable(2130840344)), null);
        continue;
        label1358:
        this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      }
    }
  }
  
  private void s()
  {
    if (this.a == null) {
      this.af.setVisibility(8);
    }
    switch (this.a.b().gifAttribution)
    {
    default: 
      this.af.setVisibility(8);
      return;
    case 1: 
      this.af.setImageDrawable(new az(b.a(getContext(), 2130840091)));
      this.af.setVisibility(0);
      return;
    }
    this.af.setImageDrawable(new az(b.a(getContext(), 2130840092)));
    this.af.setVisibility(0);
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
    Object localObject = this.a.b();
    if ((!this.a.e.b) && (!((MediaData)localObject).transferred)) {}
    do
    {
      return;
      if ((this.a.e.b) && (!((MediaData)localObject).transferred) && (!((MediaData)localObject).transcoded) && (((MediaData)localObject).doodleId != null) && (MediaFileUtils.a(this.ah, ((MediaData)localObject).doodleId).exists()))
      {
        this.l.b(getContext(), 2131296399, 1);
        return;
      }
      if (((MediaData)localObject).suspiciousContent == MediaData.SUSPICIOUS_CONTENT_YES)
      {
        this.l.b(getContext(), 2131296830, 1);
        return;
      }
      boolean bool = false;
      if (((MediaData)localObject).file != null) {
        bool = new File(Uri.fromFile(((MediaData)localObject).file).getPath()).exists();
      }
      Log.i("viewmessage/ from_me:" + this.a.e.b + " type:" + this.a.s + " name:" + this.a.y + " url:" + MediaFileUtils.a(this.a.p) + " file:" + ((MediaData)localObject).file + " progress:" + ((MediaData)localObject).progress + " transferred:" + ((MediaData)localObject).transferred + " transferring:" + ((MediaData)localObject).transferring + " fileSize:" + ((MediaData)localObject).fileSize + " media_size:" + this.a.t + " timestamp:" + this.a.n);
      if (bool) {
        break label448;
      }
      Log.w("viewmessage/ no file");
      if (!this.c) {
        break;
      }
      localObject = getContext();
    } while (!(localObject instanceof nh));
    this.l.a((nh)localObject);
    return;
    localObject = new Intent(getContext(), MediaGallery.class);
    ((Intent)localObject).putExtra("pos", -1);
    ((Intent)localObject).putExtra("alert", true);
    ((Intent)localObject).putExtra("jid", this.a.e.a);
    ((Intent)localObject).putExtra("key", this.a.e.hashCode());
    getContext().startActivity((Intent)localObject);
    return;
    label448:
    localObject = MediaView.a(this.a, this.a.e.a, getContext());
    ((Intent)localObject).putExtra("nogallery", this.c);
    getContext().startActivity((Intent)localObject);
  }
  
  public final void g()
  {
    int i = a(this.aa, this.a.b());
    CircularProgressBar localCircularProgressBar = this.aa;
    if (i == 0) {}
    for (i = b.c(getContext(), 2131624070);; i = b.c(getContext(), 2131624069))
    {
      localCircularProgressBar.setProgressBarColor(i);
      return;
    }
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903150;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903150;
  }
  
  final int getMainChildMaxWidth()
  {
    View localView = ((Activity)getContext()).getWindow().getDecorView();
    int j = Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
    int i = j;
    if (this.ak > this.aj) {
      i = (int)(j / this.ak * this.aj);
    }
    return i;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903151;
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
    if ((an != null) && (this.am == null))
    {
      this.am = new a(this.a.b());
      an.postDelayed(this.am, 2000L);
    }
  }
  
  public final void p()
  {
    this.Q.setVisibility(8);
    this.ac.setVisibility(8);
    this.af.setVisibility(8);
  }
  
  public final void q()
  {
    this.Q.setVisibility(0);
    this.ac.setVisibility(0);
    s();
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
      iy.r().post(new jb(this));
      iy.this.post(new jc(this));
    }
    
    public final void run()
    {
      if ((this.a == null) || (this.a != iy.this.a.b()) || (!iy.this.isShown()) || (iy.d(iy.this) != this) || (this.a.file == null) || (!this.a.file.exists()))
      {
        a();
        return;
      }
      long l = iy.this.getDrawingTime();
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
              if (this.a == iy.this.a.b())
              {
                k = m;
                i = n;
                j = i1;
                if (iy.this.isShown())
                {
                  i = 1;
                  j = 1;
                  k = 1;
                  iy.this.post(new ja(this, localBitmap));
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
        iy.r().postDelayed(this, 2000L);
        return;
        i = n;
        j = i1;
        this.b += 1000000L;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/iy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */