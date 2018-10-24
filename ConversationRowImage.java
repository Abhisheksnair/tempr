package com.whatsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.support.v7.widget.q;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.Window;
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
import com.whatsapp.util.az;
import java.io.File;

public final class ConversationRowImage
  extends jm
{
  public static final Drawable O = new az(u.a().getApplicationContext().getResources().getDrawable(2130837639));
  public static final Drawable P = new az(u.a().getApplicationContext().getResources().getDrawable(2130837647));
  private static final Drawable af = new az(u.a().getApplicationContext().getResources().getDrawable(2130837646));
  private final TextView Q;
  private final RowImageView R;
  private final CircularProgressBar S;
  private final ImageView aa;
  private final View ab;
  private final TextEmojiLabel ac;
  private final View ad;
  private final ag ae;
  private ag.a ag;
  
  public ConversationRowImage(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    if (isInEditMode()) {}
    for (paramContext = null;; paramContext = ag.a())
    {
      this.ae = paramContext;
      this.ag = new ag.a()
      {
        public final int a()
        {
          View localView = ((Activity)ConversationRowImage.this.getContext()).getWindow().getDecorView();
          return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
        }
        
        public final void a(View paramAnonymousView)
        {
          ConversationRowImage.a(ConversationRowImage.this).setBackgroundColor(-7829368);
        }
        
        public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
        {
          if (paramAnonymousBitmap != null)
          {
            ConversationRowImage.a(ConversationRowImage.this).setImageBitmap(paramAnonymousBitmap);
            paramAnonymousView = paramAnonymousj.b();
            if ((paramAnonymousView.width != 0) && (paramAnonymousView.height != 0))
            {
              ConversationRowImage.RowImageView.a(ConversationRowImage.a(ConversationRowImage.this), paramAnonymousView.width);
              ConversationRowImage.RowImageView.b(ConversationRowImage.a(ConversationRowImage.this), paramAnonymousView.height);
            }
            ConversationRowImage.a(ConversationRowImage.this).invalidate();
            return;
          }
          ConversationRowImage.a(ConversationRowImage.this).setImageResource(2130840347);
        }
      };
      this.Q = ((TextView)findViewById(2131755580));
      this.R = ((RowImageView)findViewById(2131755173));
      this.S = ((CircularProgressBar)findViewById(2131755238));
      this.S.setProgressBarBackgroundColor(0);
      this.aa = ((ImageView)findViewById(2131755300));
      this.ab = findViewById(2131755579);
      this.ad = findViewById(2131755614);
      this.ac = ((TextEmojiLabel)findViewById(2131755436));
      this.ac.setLinkHandler(new th());
      this.ac.setAutoLinkMask(0);
      this.ac.setLinksClickable(false);
      this.ac.setFocusable(false);
      this.ac.setClickable(false);
      this.ac.setLongClickable(false);
      c(true);
      return;
    }
  }
  
  private void c(boolean paramBoolean)
  {
    int i = 1;
    MediaData localMediaData = this.a.b();
    this.R.setImageBitmap(null);
    RowImageView.a(this.R, localMediaData);
    RowImageView.a(this.R, this.d);
    ab.a(this.R, b(this.a));
    ab.a(this.n, c(this.a));
    if (this.o != null) {
      ab.a(this.o, d(this.a));
    }
    if (localMediaData.transferring)
    {
      f();
      this.ab.setVisibility(0);
      if (!paramBoolean)
      {
        paramBoolean = true;
        a(true, paramBoolean, this.ab, this.S, this.aa, this.Q);
        this.R.setContentDescription(getContext().getString(2131297038));
        if (!this.a.e.b) {
          break label407;
        }
        this.R.setOnClickListener(this.W);
        label174:
        this.Q.setOnClickListener(this.V);
        this.S.setOnClickListener(this.V);
        label196:
        g();
        this.R.setOnLongClickListener(this.u);
        a(this.ad, this.ac);
        RowImageView.b(this.R, TextUtils.isEmpty(this.a.z));
        RowImageView.c(this.R, this.a.e.b);
        if (this.n != null)
        {
          if ((!this.a.E) || (!this.a.e.b) || (cs.e(this.a.e.a))) {
            break label757;
          }
          TextView localTextView = this.n;
          if (!TextUtils.isEmpty(this.a.z)) {
            break label750;
          }
          i = 2130837657;
          label328:
          localTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        }
        label337:
        if ((localMediaData.width == 0) || (localMediaData.height == 0)) {
          break label771;
        }
        RowImageView.a(this.R, localMediaData.width);
        RowImageView.b(this.R, localMediaData.height);
      }
    }
    for (;;)
    {
      this.ae.a(this.a, this.R, this.ag);
      this.R.requestLayout();
      return;
      paramBoolean = false;
      break;
      label407:
      this.R.setOnClickListener(null);
      break label174;
      if ((localMediaData.transferred) || ((this.a.E) && (this.a.e.b) && (!j.b(this.a.e.a))))
      {
        e();
        this.ab.setVisibility(8);
        a(false, false, this.ab, this.S, this.aa, this.Q);
        this.R.setContentDescription(getContext().getString(2131296284));
        this.Q.setOnClickListener(this.W);
        this.R.setOnClickListener(this.W);
        break label196;
      }
      f();
      this.ab.setVisibility(0);
      if (!paramBoolean)
      {
        paramBoolean = true;
        label558:
        a(false, paramBoolean, this.ab, this.S, this.aa, this.Q);
        this.R.setContentDescription(null);
        if ((!this.a.e.b) || (localMediaData.file != null) || (this.a.p == null)) {
          break label687;
        }
      }
      for (;;)
      {
        if ((!this.a.e.b) || (i != 0)) {
          break label692;
        }
        this.Q.setText(2131297619);
        this.Q.setCompoundDrawablesWithIntrinsicBounds(2130837714, 0, 0, 0);
        this.Q.setOnClickListener(this.U);
        this.R.setOnClickListener(this.W);
        break;
        paramBoolean = false;
        break label558;
        label687:
        i = 0;
      }
      label692:
      this.Q.setText(Formatter.formatShortFileSize(u.a(), this.a.t));
      this.Q.setCompoundDrawablesWithIntrinsicBounds(2130837663, 0, 0, 0);
      this.Q.setOnClickListener(this.T);
      this.R.setOnClickListener(this.T);
      break label196;
      label750:
      i = 2130837656;
      break label328;
      label757:
      this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label337;
      label771:
      i = ag.a(this.a, 100);
      if (i > 0)
      {
        RowImageView.a(this.R, 100);
        RowImageView.b(this.R, i);
      }
      else
      {
        RowImageView.a(this.R, aoa.a().l);
        RowImageView.b(this.R, RowImageView.a(this.R) * 9 / 16);
      }
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
    Object localObject = this.a.b();
    if ((!this.a.e.b) && (!((MediaData)localObject).transferred)) {
      return;
    }
    if (((MediaData)localObject).file != null) {}
    for (boolean bool = new File(Uri.fromFile(((MediaData)localObject).file).getPath()).exists();; bool = false)
    {
      Log.i("viewmessage/ from_me:" + this.a.e.b + " type:" + this.a.s + " name:" + this.a.y + " url:" + MediaFileUtils.a(this.a.p) + " file:" + ((MediaData)localObject).file + " progress:" + ((MediaData)localObject).progress + " transferred:" + ((MediaData)localObject).transferred + " transferring:" + ((MediaData)localObject).transferring + " fileSize:" + ((MediaData)localObject).fileSize + " media_size:" + this.a.t + " timestamp:" + this.a.n);
      if (!bool)
      {
        Log.w("viewmessage/ no file");
        if (this.c)
        {
          localObject = getContext();
          if (!(localObject instanceof nh)) {
            break;
          }
          this.l.a((nh)localObject);
          return;
        }
        localObject = new Intent(getContext(), MediaGallery.class);
        ((Intent)localObject).putExtra("pos", -1);
        ((Intent)localObject).putExtra("alert", true);
        ((Intent)localObject).putExtra("jid", this.a.e.a);
        ((Intent)localObject).putExtra("key", this.a.e.hashCode());
        getContext().startActivity((Intent)localObject);
        return;
      }
      localObject = MediaView.a(this.a, this.a.e.a, getContext(), this.R);
      if (this.c) {
        ((Intent)localObject).putExtra("nogallery", true);
      }
      getContext().startActivity((Intent)localObject);
      if ((!MediaView.l()) || (!(getContext() instanceof Activity))) {
        break;
      }
      ((Activity)getContext()).overridePendingTransition(0, 0);
      return;
    }
  }
  
  public final void g()
  {
    int i = a(this.S, this.a.b());
    CircularProgressBar localCircularProgressBar = this.S;
    if (i == 0) {}
    for (i = b.c(getContext(), 2131624070);; i = b.c(getContext(), 2131624069))
    {
      localCircularProgressBar.setProgressBarColor(i);
      return;
    }
  }
  
  protected final int getCenteredLayoutId()
  {
    return 2130903152;
  }
  
  protected final int getIncomingLayoutId()
  {
    return 2130903152;
  }
  
  final int getMainChildMaxWidth()
  {
    View localView = ((Activity)getContext()).getWindow().getDecorView();
    return Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
  }
  
  protected final int getOutgoingLayoutId()
  {
    return 2130903153;
  }
  
  protected final int getStarDrawable()
  {
    if (TextUtils.isEmpty(this.a.z)) {
      return 2130840366;
    }
    return 2130840365;
  }
  
  public final void i()
  {
    super.i();
    c(false);
  }
  
  public static class RowImageView
    extends q
  {
    private int a;
    private int b;
    private Bitmap c;
    private boolean d;
    private boolean e;
    private boolean f;
    private final Paint g = new Paint();
    private final Rect h = new Rect();
    private final Rect i = new Rect();
    private MediaData j;
    private final pv k;
    
    public RowImageView(Context paramContext)
    {
      super();
      if (isInEditMode()) {}
      for (paramContext = null;; paramContext = pv.a())
      {
        this.k = paramContext;
        a();
        return;
      }
    }
    
    public RowImageView(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      if (isInEditMode()) {}
      for (paramContext = null;; paramContext = pv.a())
      {
        this.k = paramContext;
        a();
        return;
      }
    }
    
    public RowImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
      if (isInEditMode()) {}
      for (paramContext = null;; paramContext = pv.a())
      {
        this.k = paramContext;
        a();
        return;
      }
    }
    
    private void a()
    {
      this.g.setAntiAlias(true);
      this.g.setDither(true);
      this.g.setFilterBitmap(true);
      this.g.setColor(-1);
    }
    
    protected void onDraw(Canvas paramCanvas)
    {
      this.g.setColor(-1);
      this.h.set(0, 0, getWidth(), getHeight());
      int m;
      if ((this.c != null) && (!this.f))
      {
        this.i.set(0, 0, this.c.getWidth(), this.c.getHeight());
        if (this.c.getHeight() > this.c.getWidth())
        {
          this.i.bottom = this.c.getWidth();
          if (this.j.faceY > 0)
          {
            m = this.j.faceY;
            if (m > this.a / 3)
            {
              int n = this.i.bottom;
              this.i.bottom = Math.min(this.c.getHeight(), m * this.c.getHeight() / this.b + n * 2 / 3);
              this.i.top = (this.i.bottom - n);
              if (this.i.top < 0)
              {
                this.i.top = 0;
                this.i.bottom = n;
              }
            }
            label208:
            paramCanvas.drawBitmap(this.c, this.i, this.h, this.g);
            label228:
            if (!isInEditMode()) {
              break label340;
            }
          }
        }
      }
      label340:
      do
      {
        return;
        m = this.b / 3;
        break;
        if (this.c.getWidth() * 10 <= this.c.getHeight() * 24) {
          break label208;
        }
        this.i.left = ((this.c.getWidth() - this.c.getHeight() * 24 / 10) / 2);
        this.i.right = ((this.c.getWidth() + this.c.getHeight() * 24 / 10) / 2);
        break label208;
        super.onDraw(paramCanvas);
        break label228;
        if (this.d)
        {
          if (!this.k.d()) {
            break label447;
          }
          ConversationRowImage.p().setBounds(this.h.right - ConversationRowImage.p().getIntrinsicWidth(), this.h.bottom - ConversationRowImage.p().getIntrinsicHeight(), this.h.right, this.h.bottom);
          ConversationRowImage.p().draw(paramCanvas);
        }
      } while (this.f);
      if (this.e) {}
      for (Drawable localDrawable = ConversationRowImage.P;; localDrawable = ConversationRowImage.O)
      {
        localDrawable.setBounds(this.h);
        localDrawable.draw(paramCanvas);
        return;
        label447:
        ConversationRowImage.p().setBounds(this.h.left, this.h.bottom - ConversationRowImage.p().getIntrinsicHeight(), this.h.left + ConversationRowImage.p().getIntrinsicWidth(), this.h.bottom);
        break;
      }
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      if (isInEditMode())
      {
        setMeasuredDimension(800, 600);
        return;
      }
      if (this.f)
      {
        paramInt1 = View.MeasureSpec.getSize(paramInt1);
        paramInt2 = this.b * paramInt1 / this.a;
      }
      for (;;)
      {
        setMeasuredDimension(paramInt1, paramInt2);
        return;
        View localView = ((Activity)getContext()).getWindow().getDecorView();
        int m = Math.min(localView.getWidth(), localView.getHeight()) * 72 / 100;
        paramInt2 = m;
        if (View.MeasureSpec.getMode(paramInt1) == Integer.MIN_VALUE) {
          paramInt2 = Math.min(m, View.MeasureSpec.getSize(paramInt1));
        }
        m = this.b * paramInt2 / this.a;
        if (m > paramInt2)
        {
          paramInt1 = paramInt2;
        }
        else if (paramInt2 * 10 > m * 24)
        {
          m = paramInt2 * 10 / 24;
          paramInt1 = paramInt2;
          paramInt2 = m;
        }
        else
        {
          paramInt1 = paramInt2;
          paramInt2 = m;
        }
      }
    }
    
    public void setImageBitmap(Bitmap paramBitmap)
    {
      this.c = paramBitmap;
      if (paramBitmap == null)
      {
        super.setImageDrawable(null);
        return;
      }
      super.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ConversationRowImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */