package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.b;
import android.support.v7.app.b.a;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.whatsapp.data.ad;
import com.whatsapp.data.ad.e;
import com.whatsapp.data.cm;
import com.whatsapp.data.cs;
import com.whatsapp.emoji.c.c;
import com.whatsapp.j.a.a;
import com.whatsapp.preference.WaFontListPreference;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.protocol.s;
import com.whatsapp.statusplayback.StatusPlaybackActivity;
import com.whatsapp.util.Log;
import com.whatsapp.util.aa;
import com.whatsapp.util.ag;
import com.whatsapp.util.ag.a;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import com.whatsapp.util.bg;
import com.whatsapp.util.bh;
import com.whatsapp.util.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class hy
  extends at
  implements com.whatsapp.f.c
{
  private static float ae = 0.0F;
  private static float af = 0.0F;
  private static Paint ag;
  private static final int ah = Math.max(64, Math.min(512, (int)(Runtime.getRuntime().maxMemory() / 16L / 16384L)));
  protected final aic A = aic.a();
  protected final cm B = cm.a();
  protected final aoj C = aoj.a();
  protected final br D = br.a();
  protected final ad E = ad.a();
  protected final com.whatsapp.data.e F = com.whatsapp.data.e.a();
  protected final and G = and.a();
  protected final aus H = aus.a();
  protected final aq I = aq.a();
  protected final qz J = qz.a();
  protected final sr K = sr.a();
  protected final ag L = ag.a();
  protected final atv M = atv.a();
  protected final rh N = rh.a();
  private ImageView O;
  private TextView P;
  private final View Q;
  private ImageView R;
  private View S;
  private TextEmojiLabel T;
  private TextEmojiLabel U;
  private TextView V;
  private ImageView W;
  private ViewGroup aa;
  private FrameLayout ab;
  private com.whatsapp.f.e ac;
  private int ad = -1;
  private final com.whatsapp.data.l ai = com.whatsapp.data.l.a();
  private final Runnable aj = ib.a(this);
  private View.OnClickListener ak = ic.a(this);
  final TextView n;
  protected final ImageView o;
  protected final ViewGroup p;
  protected View q;
  boolean r = false;
  int s;
  protected View.OnTouchListener t = hz.a(this);
  protected View.OnLongClickListener u = ia.a(this);
  protected final ant v = ant.a();
  protected final va w = va.a();
  protected final ahx x = ahx.a();
  protected final com.whatsapp.data.d y = com.whatsapp.data.d.a();
  protected final ahc z = ahc.a();
  
  public hy(Context paramContext, j paramj)
  {
    super(paramContext, paramj);
    paramContext = getRowsContainer();
    boolean bool;
    label229:
    int i;
    if (paramContext != null)
    {
      if (paramContext.z() == 1)
      {
        bool = true;
        this.c = bool;
        if (paramContext.z() != 2) {
          break label462;
        }
        bool = true;
        this.d = bool;
      }
    }
    else
    {
      setClipToPadding(false);
      paramContext = aoa.a();
      if (!this.c) {
        break label468;
      }
      i = paramContext.h;
      label256:
      if (!this.d) {
        break label476;
      }
      i = getContext().getResources().getDimensionPixelSize(2131361893);
      setPadding(0, i, 0, i);
      label285:
      setBackgroundDrawable(new Drawable()
      {
        public final void draw(Canvas paramAnonymousCanvas) {}
        
        public final int getOpacity()
        {
          return -3;
        }
        
        public final boolean isStateful()
        {
          return true;
        }
        
        protected final boolean onLevelChange(int paramAnonymousInt)
        {
          return true;
        }
        
        protected final boolean onStateChange(int[] paramAnonymousArrayOfInt)
        {
          return true;
        }
        
        public final void setAlpha(int paramAnonymousInt) {}
        
        public final void setColorFilter(ColorFilter paramAnonymousColorFilter) {}
        
        public final boolean setState(int[] paramAnonymousArrayOfInt)
        {
          invalidateSelf();
          return true;
        }
      });
      setLongClickable(true);
      this.n = ((TextView)findViewById(2131755328));
      this.o = ((ImageView)findViewById(2131755329));
      if (this.d) {
        break label766;
      }
      this.Q = findViewById(2131755570);
      label348:
      this.p = ((ViewGroup)findViewById(2131755586));
      b(paramj);
      setOnLongClickListener(this.u);
      if (ag == null)
      {
        paramContext = new Paint();
        ag = paramContext;
        paramContext.setColor(1295234533);
        ag.setStyle(Paint.Style.FILL);
        ag.setAntiAlias(true);
      }
      if (!p()) {
        break label774;
      }
      s();
      this.q.setSelected(getRowsContainer().c(paramj));
    }
    for (;;)
    {
      this.ac = new com.whatsapp.f.e();
      return;
      bool = false;
      break;
      label462:
      bool = false;
      break label229;
      label468:
      i = paramContext.f;
      break label256;
      label476:
      if ((paramj.d == 6) && (paramj.s != 8))
      {
        setPadding(paramContext.b, paramContext.f + j.top, paramContext.b, j.bottom + i);
        break label285;
      }
      pv localpv;
      int j;
      int k;
      if (a())
      {
        localpv = this.l;
        j = k.left;
        k = paramContext.f;
        al.a(localpv, this, j, k.top + k, k.right, i + k.bottom);
      }
      for (;;)
      {
        setMinimumHeight((int)getResources().getDimension(2131361938));
        break;
        int m;
        int i1;
        int i2;
        if (paramj.e.b)
        {
          localpv = this.l;
          j = paramContext.b;
          k = i.left;
          m = paramContext.f;
          i1 = i.top;
          i2 = paramContext.b;
          al.a(localpv, this, k + j, i1 + m, i.right + i2, i + i.bottom);
        }
        else
        {
          localpv = this.l;
          j = paramContext.b;
          k = j.left;
          m = paramContext.f;
          i1 = j.top;
          i2 = paramContext.b;
          al.a(localpv, this, k + j, i1 + m, j.right + i2, i + j.bottom);
        }
      }
      label766:
      this.Q = null;
      break label348;
      label774:
      r();
    }
  }
  
  static float a(Resources paramResources)
  {
    float f;
    if (ae == 0.0F)
    {
      f = paramResources.getDisplayMetrics().scaledDensity;
      ae = paramResources.getDimension(2131361924) / f;
    }
    int i = 0;
    if (WaFontListPreference.a == -1) {
      i = -2;
    }
    for (;;)
    {
      f = ae;
      return i + f;
      if (WaFontListPreference.a == 1) {
        i = 4;
      }
    }
  }
  
  public static float a(Resources paramResources, aus paramaus)
  {
    return a(paramResources, paramaus, WaFontListPreference.a);
  }
  
  public static float a(Resources paramResources, aus paramaus, int paramInt)
  {
    float f;
    if (af == 0.0F)
    {
      f = paramResources.getDisplayMetrics().scaledDensity;
      af = paramResources.getDimension(2131361943) / f;
    }
    int i = 0;
    if (paramInt == -1) {
      i = -2;
    }
    for (;;)
    {
      if (!paramaus.d().equals("ar"))
      {
        paramInt = i;
        if (!paramaus.d().equals("fa")) {}
      }
      else
      {
        paramInt = i + 1;
      }
      f = af;
      return paramInt + f;
      if (paramInt == 1) {
        i = 4;
      }
    }
  }
  
  private static CharSequence a(Context paramContext, com.whatsapp.data.e parame, and paramand, CharSequence paramCharSequence, List<String> paramList1, List<String> paramList2)
  {
    return bg.b(paramContext, yr.a(paramContext, parame, be.a(paramContext, paramand, paramCharSequence), paramList2), paramList1);
  }
  
  public static void a(pv parampv, va paramva, com.whatsapp.data.d paramd, com.whatsapp.data.e parame, and paramand, aus paramaus, final ag paramag, rh paramrh, View paramView, String paramString, j paramj, ArrayList<String> paramArrayList)
  {
    Context localContext = paramView.getContext();
    TextEmojiLabel localTextEmojiLabel2 = (TextEmojiLabel)paramView.findViewById(2131756047);
    TextEmojiLabel localTextEmojiLabel1 = (TextEmojiLabel)paramView.findViewById(2131756050);
    final ImageView localImageView = (ImageView)paramView.findViewById(2131756051);
    View localView = paramView.findViewById(2131756046);
    paramag.b(paramj, localImageView, new ag.a()
    {
      public final int a()
      {
        return paramag.c();
      }
      
      public final void a(View paramAnonymousView)
      {
        localImageView.setImageDrawable(new ColorDrawable(-7829368));
      }
      
      public final void a(View paramAnonymousView, Bitmap paramAnonymousBitmap, j paramAnonymousj)
      {
        if ((paramAnonymousBitmap != null) && (paramAnonymousBitmap.getWidth() > 0) && (paramAnonymousBitmap.getHeight() > 0) && (!j.b(this.a)))
        {
          localImageView.setVisibility(0);
          localImageView.setImageBitmap(paramAnonymousBitmap);
          return;
        }
        localImageView.setVisibility(8);
      }
    }, "quoted-" + paramj.e);
    if (paramj.e.b)
    {
      paramag = paramva.c();
      i = b.c(localContext, 2131623944);
      localView.setBackgroundColor(i);
      localTextEmojiLabel2.setTextColor(i);
      if (!paramva.a(paramag.t)) {
        break label441;
      }
      localTextEmojiLabel2.setText(2131298216);
      localTextEmojiLabel2.setCompoundDrawables(null, null, null, null);
      label169:
      paramag = (TextView)paramView.findViewById(2131756048);
      paramString = (TextView)paramView.findViewById(2131756049);
      if (!paramj.a()) {
        break label451;
      }
      paramag.setVisibility(0);
      paramString.setVisibility(0);
      paramag.setTextColor(i);
      paramString.setTextColor(i);
      label229:
      paramag = paramView.getContext();
      paramString = localTextEmojiLabel1.getPaint();
    }
    switch (paramj.s)
    {
    case 6: 
    case 7: 
    case 12: 
    default: 
      parampv = paramag.getString(2131296580);
    case 0: 
    case 1: 
    case 2: 
    case 13: 
    case 3: 
    case 9: 
    case 4: 
    case 14: 
    case 5: 
    case 16: 
    case 8: 
    case 10: 
    case 11: 
      for (;;)
      {
        localTextEmojiLabel1.setText(com.whatsapp.emoji.c.a(parampv, paramView.getContext(), localTextEmojiLabel1.getPaint()));
        return;
        if ((qz.e(paramString)) || (j.b(paramString)))
        {
          paramag = parame.d(paramj.f);
          paramString = paramrh.a(paramString, paramj.f);
          if (paramString != null)
          {
            i = paramString.e;
            break;
          }
          i = -1728053248;
          break;
        }
        paramag = parame.d(paramString);
        i = -7391088;
        break;
        label441:
        localTextEmojiLabel2.setContact(paramag);
        break label169;
        label451:
        paramag.setVisibility(8);
        paramString.setVisibility(8);
        break label229;
        if (paramj.d == 6)
        {
          parampv = yr.a(paramag, parame, ip.a(parampv, paramva, paramd, parame, paramaus, paramrh, paramj), paramj.P);
        }
        else
        {
          parampv = a(paramag, parame, paramand, paramj.e(), paramArrayList, paramj.P);
          continue;
          if (TextUtils.isEmpty(paramj.z)) {}
          for (parampv = paramag.getString(2131296577);; parampv = a(paramag, parame, paramand, paramj.z, paramArrayList, paramj.P))
          {
            parampv = bh.b(parampv, b.a(paramag, 2130840380), paramString);
            break;
          }
          if (paramj.o == 1)
          {
            i = 2131296585;
            label606:
            paramva = paramag.getString(i);
            parampv = paramva;
            if (paramj.w != 0) {
              parampv = paramva + " (" + DateUtils.formatElapsedTime(paramj.w) + ")";
            }
            if (paramj.o != 1) {
              break label702;
            }
          }
          label702:
          for (i = 2130840394;; i = 2130840379)
          {
            parampv = bh.b(parampv, b.a(paramag, i), paramString);
            break;
            i = 2131296570;
            break label606;
          }
          if (TextUtils.isEmpty(paramj.z)) {}
          for (parampv = paramag.getString(2131296576);; parampv = a(paramag, parame, paramand, paramj.z, paramArrayList, paramj.P))
          {
            parampv = bh.b(be.a(paramag, paramand, parampv), b.a(paramag, 2130840387), paramString);
            break;
          }
          if (TextUtils.isEmpty(paramj.z)) {}
          for (parampv = paramag.getString(2131296581);; parampv = a(paramag, parame, paramand, paramj.z, paramArrayList, paramj.P))
          {
            paramva = parampv;
            if (paramj.w != 0) {
              paramva = parampv + " (" + DateUtils.formatElapsedTime(paramj.w) + ")";
            }
            parampv = bh.b(be.a(paramag, paramand, paramva), b.a(paramag, 2130840399), paramString);
            break;
          }
          if (TextUtils.isEmpty(paramj.z)) {}
          for (parampv = paramag.getString(2131296575);; parampv = bg.b(paramag, paramj.z, paramArrayList))
          {
            paramva = parampv;
            if (paramj.x != 0) {
              paramva = parampv + " (" + p.a(paramj) + ")";
            }
            parampv = bh.b(be.a(paramag, paramand, paramva), b.a(paramag, 2130840385), paramString);
            break;
          }
          paramva = paramag.getString(2131296572);
          parampv = paramva;
          if (!TextUtils.isEmpty(paramj.y)) {
            parampv = paramva + ": " + bg.b(paramag, paramj.y, paramArrayList);
          }
          parampv = bh.b(parampv, b.a(paramag, 2130840384), paramString);
          continue;
          parampv = bh.b(a.a.a.a.d.c(paramj), b.a(paramag, 2130840384), paramString);
          continue;
          paramva = null;
          parampv = paramva;
          if (!TextUtils.isEmpty(paramj.y))
          {
            paramd = paramj.y.split("\n");
            parampv = paramva;
            if (paramd.length != 0) {
              parampv = paramd[0];
            }
          }
          if (TextUtils.isEmpty(parampv)) {}
          for (parampv = paramag.getString(2131296579);; parampv = bg.b(paramag, parampv, paramArrayList))
          {
            parampv = bh.b(parampv, b.a(paramag, 2130840391), paramString);
            break;
          }
          if (TextUtils.isEmpty(paramj.z)) {}
          for (parampv = paramag.getString(2131296578);; parampv = a(paramag, parame, paramand, paramj.z, paramArrayList, paramj.P))
          {
            parampv = bh.b(parampv, b.a(paramag, 2130840182), paramString);
            break;
          }
          parampv = paramag.getString(2131296571);
          continue;
          parampv = paramag.getString(2131296587);
          continue;
          parampv = paramag.getString(2131296574);
        }
      }
    }
    if (paramj.e.b) {}
    for (int i = 2131297624;; i = 2131297623)
    {
      parampv = paramag.getString(i);
      break;
    }
  }
  
  public static float b(Resources paramResources, aus paramaus)
  {
    return a(paramResources, paramaus) * 24.0F / 27.0F;
  }
  
  private void b(final j paramj)
  {
    int k;
    final Object localObject2;
    Object localObject1;
    int i;
    if (paramj != this.a)
    {
      k = 1;
      if (k != 0)
      {
        clearAnimation();
        this.f = 0.0F;
        invalidate();
      }
      this.a = paramj;
      setTag(paramj.e);
      localObject2 = this.a.V;
      if ((localObject2 == null) || (((j)localObject2).s > 17) || (((j)localObject2).s < 0)) {
        break label1465;
      }
      if (this.aa == null) {
        this.aa = ((ViewGroup)findViewById(2131755582));
      }
      if (this.aa != null)
      {
        this.aa.setVisibility(0);
        if (this.ab == null)
        {
          this.ab = ((FrameLayout)((FrameLayout)al.a(this.l, LayoutInflater.from(getContext()), 2130903342, this.aa, true)).findViewById(2131756045));
          localObject1 = this.ab;
          localObject3 = getContext();
          if (!this.a.e.b) {
            break label1458;
          }
          i = 2130837647;
          label184:
          ((FrameLayout)localObject1).setForeground(b.a((Context)localObject3, i));
          localObject1 = (TextView)this.ab.findViewById(2131756047);
          localObject3 = (TextView)this.ab.findViewById(2131756048);
          localObject4 = (TextView)this.ab.findViewById(2131756049);
          float f = getNameInGroupTextFontSize();
          ((TextView)localObject1).setTextSize(f);
          ((TextView)localObject3).setTextSize(f);
          ((TextView)localObject4).setTextSize(f);
          aoa.b((TextView)localObject1);
          aoa.b((TextView)localObject3);
          aoa.b((TextView)localObject4);
        }
        if ((getContext() instanceof Conversation))
        {
          this.ab.setOnClickListener(new com.whatsapp.util.at()
          {
            public final void a(View paramAnonymousView)
            {
              paramAnonymousView = hy.b(hy.this).a(localObject2.e);
              if ((paramAnonymousView == null) && (localObject2.e.b)) {
                paramAnonymousView = hy.b(hy.this).a(new j.b("status@broadcast", true, localObject2.e.c));
              }
              for (;;)
              {
                if (paramAnonymousView != null)
                {
                  if (paramAnonymousView.a())
                  {
                    localObject = new Intent(hy.this.getContext(), StatusPlaybackActivity.class);
                    ((Intent)localObject).putExtra("jid", paramAnonymousView.f);
                    ((Intent)localObject).putExtra("message_key", new FMessageKey(paramAnonymousView.e));
                    hy.this.getContext().startActivity((Intent)localObject);
                  }
                }
                else {
                  return;
                }
                Object localObject = (Conversation)hy.this.getContext();
                ((Conversation)localObject).M = paramAnonymousView.e;
                if (paramAnonymousView.Q < ((Conversation)localObject).B)
                {
                  ad.e locale = ((Conversation)localObject).Q.b(((Conversation)localObject).t, paramAnonymousView.Q, ((Conversation)localObject).d(true));
                  ((Conversation)localObject).y.clear();
                  ((Conversation)localObject).x.clear();
                  ((Conversation)localObject).B = locale.a;
                  int i = ((Conversation)localObject).U.getFirstVisiblePosition();
                  int j = ((Conversation)localObject).V.getCount();
                  int k = ((Conversation)localObject).getResources().getDimensionPixelSize(2131361938);
                  Log.d("conversation/scroll-to-message/ before pos :" + i + " adapter count:" + j);
                  ((Conversation)localObject).V.changeCursor(locale.b);
                  int m = Conversation.d.a(((Conversation)localObject).V, ((Conversation)localObject).Q.a(((Conversation)localObject).t, ((Conversation)localObject).B, paramAnonymousView.Q)) + ((Conversation)localObject).U.getHeaderViewsCount();
                  ((Conversation)localObject).U.setSelectionFromTop(((Conversation)localObject).V.getCount() + i - j, k);
                  Log.d("conversation/scroll-to-message/ after pos:" + m + " adapter count:" + ((Conversation)localObject).V.getCount());
                  ((Conversation)localObject).U.getViewTreeObserver().addOnGlobalLayoutListener(new Conversation.30((Conversation)localObject, paramAnonymousView, m));
                  return;
                }
                ((Conversation)localObject).V.notifyDataSetChanged();
                ((Conversation)localObject).f(Conversation.d.a(((Conversation)localObject).V, ((Conversation)localObject).Q.a(((Conversation)localObject).t, ((Conversation)localObject).B, paramAnonymousView.Q)) + ((Conversation)localObject).U.getHeaderViewsCount());
                return;
              }
            }
          });
          this.ab.setOnLongClickListener(this.u);
        }
        Object localObject3 = this.l;
        Object localObject4 = this.w;
        com.whatsapp.data.d locald = this.y;
        com.whatsapp.data.e locale = this.F;
        and localand = this.G;
        aus localaus = this.H;
        ag localag = this.L;
        rh localrh = this.N;
        FrameLayout localFrameLayout = this.ab;
        String str = this.a.e.a;
        if (getRowsContainer() != null) {
          break label1484;
        }
        localObject1 = null;
        label392:
        a((pv)localObject3, (va)localObject4, locald, locale, localand, localaus, localag, localrh, localFrameLayout, str, (j)localObject2, (ArrayList)localObject1);
      }
      label419:
      if (!q()) {
        break label1498;
      }
      if (this.R == null)
      {
        this.R = new ImageView(getContext());
        this.R.setScaleType(ImageView.ScaleType.CENTER);
        this.R.setImageResource(2130840211);
        i = getContext().getResources().getDimensionPixelSize(2131361939);
        addView(this.R, i, i);
        this.R.setOnClickListener(new com.whatsapp.util.at()
        {
          public final void a(View paramAnonymousView)
          {
            if (hy.this.I.a(paramj.e.a))
            {
              a.a.a.a.d.a((Activity)hy.this.getContext(), 106);
              return;
            }
            ArrayList localArrayList = hy.this.E.b(paramj.e.a, paramj.n);
            android.support.v7.widget.at localat = new android.support.v7.widget.at(hy.this.getContext(), hy.c(hy.this));
            localat.a().add(0, 1, 0, 2131297616);
            if (localArrayList.size() > 1) {
              if (!com.whatsapp.util.l.d(paramj.n + 86400000L)) {
                break label195;
              }
            }
            label195:
            for (paramAnonymousView = String.format(u.a.a(2131230792, localArrayList.size()), new Object[] { Integer.valueOf(localArrayList.size()) });; paramAnonymousView = String.format(u.a.a(2131230791, localArrayList.size()), new Object[] { Integer.valueOf(localArrayList.size()), com.whatsapp.util.l.b(paramj.n) }))
            {
              localat.a().add(0, 2, 0, paramAnonymousView);
              localat.a(new ie(this, paramj, localArrayList));
              localat.b();
              return;
            }
          }
        });
      }
      if (this.o != null) {
        this.o.setVisibility(8);
      }
    }
    for (;;)
    {
      if (!this.d) {
        break label1536;
      }
      al.a(this.l, this, 0, 0);
      if (this.n != null)
      {
        this.n.setText(com.whatsapp.util.l.a(getContext(), this.v.a(paramj)));
        if ((!paramj.E) || (!paramj.e.b) || (cs.e(paramj.e.a))) {
          break label1660;
        }
        this.n.setCompoundDrawablesWithIntrinsicBounds(2130837656, 0, 0, 0);
      }
      label613:
      if (this.p != null)
      {
        if (!paramj.T) {
          break label1674;
        }
        if (this.O == null)
        {
          this.O = new ImageView(getContext());
          localObject1 = new LinearLayout.LayoutParams(-2, -2);
          ((LinearLayout.LayoutParams)localObject1).gravity = 16;
          this.O.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          al.a(this.l, this.O, 0, aoa.a().e);
          this.p.addView(this.O, 0);
          this.p.setClipChildren(false);
        }
        this.O.setImageResource(getStarDrawable());
        this.O.setVisibility(0);
      }
      label735:
      if ((this.o != null) && (paramj.e.b))
      {
        i = a(paramj.d);
        if (i != this.ad)
        {
          if ((k != 0) || (this.ad <= 0) || (s.a(paramj.d, 13) < 0)) {
            break label1692;
          }
          localObject1 = new aag(this.o, i);
          ((Animation)localObject1).setDuration(400L);
          ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
          this.o.startAnimation((Animation)localObject1);
        }
        label836:
        if ((paramj.s == 15) && (s.a(paramj.d, 4) >= 0)) {
          this.o.setVisibility(4);
        }
        this.ad = i;
      }
      if ((!paramj.e.b) && (qz.e(paramj.e.a)) && (!this.c) && (!this.d))
      {
        if (paramj.f == null) {
          break label1724;
        }
        localObject1 = (TextEmojiLabel)findViewById(2131755571);
        localObject2 = this.N.a(paramj.e.a, paramj.f);
        if (localObject2 == null) {
          break label1703;
        }
        ((TextEmojiLabel)localObject1).setTextColor(((rf)localObject2).e);
        label960:
        ((TextEmojiLabel)localObject1).setTextSize(getNameInGroupTextFontSize());
        aoa.b((TextView)localObject1);
        localObject2 = this.F.d(paramj.f);
        ((TextEmojiLabel)localObject1).setContact((cs)localObject2);
        localObject1 = (TextEmojiLabel)findViewById(2131755572);
        if ((!TextUtils.isEmpty(((cs)localObject2).e)) || (((cs)localObject2).f()) || (TextUtils.isEmpty(((cs)localObject2).q))) {
          break label1714;
        }
        ((TextEmojiLabel)localObject1).a("~" + ((cs)localObject2).q);
        ((TextEmojiLabel)localObject1).setVisibility(0);
        label1068:
        if (this.e < 2) {
          this.Q.setVisibility(0);
        }
        this.Q.setOnClickListener(this.ak);
        this.Q.setBackgroundResource(2130840501);
      }
      if (this.c)
      {
        setClipToPadding(false);
        setClipChildren(false);
        if (this.S == null)
        {
          this.S = al.a(this.l, LayoutInflater.from(getContext()), 2130903367);
          ((ViewGroup)this.S).setClipToPadding(false);
          ((ViewGroup)this.S).setClipChildren(false);
          this.T = ((TextEmojiLabel)this.S.findViewById(2131756093));
          this.T.setTextSize(getNameInGroupTextFontSize());
          aoa.b(this.T);
          this.U = ((TextEmojiLabel)this.S.findViewById(2131756095));
          this.U.setTextSize(getNameInGroupTextFontSize());
          aoa.b(this.U);
          localObject2 = (TextView)this.S.findViewById(2131756094);
          ((TextView)localObject2).setTextSize(getNameInGroupTextFontSize() / 2.0F);
          if (!this.l.d()) {
            break label1750;
          }
          localObject1 = "▶";
          label1283:
          ((TextView)localObject2).setText((CharSequence)localObject1);
          this.V = ((TextView)this.S.findViewById(2131756096));
          ((ImageView)this.S.findViewById(2131755857)).setImageDrawable(new az(b.a(getContext(), 2130837733)));
          addView(this.S, new ViewGroup.MarginLayoutParams(-1, -2));
          this.h = this.S;
        }
        if (!paramj.e.b) {
          break label1758;
        }
        localObject2 = getContext().getString(2131298216);
        localObject1 = this.F.d(paramj.e.a).a(getContext());
        label1411:
        this.T.a((CharSequence)localObject2);
        this.U.a((CharSequence)localObject1);
        this.V.setText(com.whatsapp.util.l.b(getContext(), this.v.a(paramj)));
      }
      return;
      k = 0;
      break;
      label1458:
      i = 2130837639;
      break label184;
      label1465:
      if (this.aa == null) {
        break label419;
      }
      this.aa.setVisibility(8);
      break label419;
      label1484:
      localObject1 = getRowsContainer().x();
      break label392;
      label1498:
      if (this.R != null)
      {
        removeView(this.R);
        this.R = null;
      }
      if (this.o != null) {
        this.o.setVisibility(0);
      }
    }
    label1536:
    label1560:
    int j;
    if ((!a()) && (paramj.e.b))
    {
      i = i.right;
      j = i + aoa.a().b;
      if (this.R == null) {
        break label1855;
      }
      if (!this.c) {
        break label1639;
      }
      i = aoa.a().c + j;
    }
    for (;;)
    {
      int m = i;
      if (this.c) {
        m = i + aoa.a().d;
      }
      al.a(this.l, this, m, j);
      break;
      i = j.left;
      break label1560;
      label1639:
      m = aoa.a().c;
      i = j;
      j = m + j;
      continue;
      label1660:
      this.n.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      break label613;
      label1674:
      if (this.O == null) {
        break label735;
      }
      this.O.setVisibility(4);
      break label735;
      label1692:
      this.o.setImageResource(i);
      break label836;
      label1703:
      ((TextEmojiLabel)localObject1).setTextColor(-1728053248);
      break label960;
      label1714:
      ((TextEmojiLabel)localObject1).setVisibility(8);
      break label1068;
      label1724:
      Log.e("conversation_row/missing_rmt_src:" + Log.a(paramj));
      break label1068;
      label1750:
      localObject1 = "◀";
      break label1283;
      label1758:
      if (qz.e(paramj.e.a))
      {
        localObject2 = this.F.d(paramj.f).a(getContext());
        localObject1 = this.F.d(paramj.e.a).a(getContext());
        break label1411;
      }
      localObject2 = this.F.d(paramj.e.a).a(getContext());
      localObject1 = getContext().getString(2131298216);
      break label1411;
      label1855:
      i = j;
    }
  }
  
  private float getNameInGroupTextFontSize()
  {
    return b(getResources(), this.H);
  }
  
  private boolean p()
  {
    jz localjz = getRowsContainer();
    return (localjz != null) && (localjz.O());
  }
  
  private boolean q()
  {
    if ((this.a.e.b) && (this.a.d < 4) && (this.a.n + 86400000L < this.v.b()))
    {
      sr localsr = this.K;
      j.b localb = this.a.e;
      if (!localsr.c.contains(localb)) {
        break label113;
      }
    }
    label113:
    return (this.a.e.b) && (this.a.d == 7) && (!qz.e(this.a.e.a));
  }
  
  private void r()
  {
    if (this.q != null) {
      this.q.setVisibility(8);
    }
  }
  
  private void s()
  {
    if (this.q != null)
    {
      this.q.setVisibility(0);
      return;
    }
    this.q = new View(getContext())
    {
      private final Rect b = new Rect();
      
      protected final void onDraw(Canvas paramAnonymousCanvas)
      {
        super.onDraw(paramAnonymousCanvas);
        if (isSelected())
        {
          getDrawingRect(this.b);
          if (!hy.this.d) {
            break label84;
          }
          Rect localRect = this.b;
          localRect.top += hy.this.getPaddingTop();
          localRect = this.b;
          localRect.bottom -= hy.this.getPaddingBottom();
        }
        for (;;)
        {
          paramAnonymousCanvas.drawRect(this.b, hy.n());
          return;
          label84:
          if (!hy.this.c)
          {
            this.b.top = (hy.this.b.top - aoa.a().s);
            this.b.bottom = (hy.this.b.bottom + aoa.a().t);
          }
        }
      }
    };
    this.q.setClickable(true);
    this.q.setOnClickListener(id.a(this));
    setClipToPadding(false);
    addView(this.q, new RelativeLayout.LayoutParams(-1, -1));
  }
  
  protected int a(int paramInt)
  {
    int i;
    if (s.a(paramInt, 13) >= 0) {
      i = 2130840357;
    }
    for (;;)
    {
      int j = i;
      if (av.d())
      {
        j = i;
        if (paramInt == 7) {
          j = 2130840369;
        }
      }
      return j;
      if (s.a(paramInt, 5) >= 0) {
        i = 2130840361;
      } else if (s.a(paramInt, 4) == 0) {
        i = 2130840359;
      } else {
        i = 2130840369;
      }
    }
  }
  
  public final CharSequence a(CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {}
    Object localObject;
    do
    {
      do
      {
        return paramCharSequence;
        localObject = getRowsContainer();
      } while (localObject == null);
      localObject = ((jz)localObject).x();
    } while ((localObject == null) || (((ArrayList)localObject).isEmpty()));
    return bg.a(getContext(), paramCharSequence, (List)localObject, bg.b);
  }
  
  public final void a(com.whatsapp.f.d paramd)
  {
    this.ac.a(paramd);
  }
  
  public void a(j arg1, boolean paramBoolean)
  {
    if ((this.a != ???) || (paramBoolean)) {
      b(???);
    }
    if (p())
    {
      s();
      this.q.setSelected(getRowsContainer().c(this.a));
    }
    for (;;)
    {
      com.whatsapp.f.e locale = this.ac;
      synchronized (locale.a)
      {
        locale.a.clear();
        return;
        r();
      }
    }
  }
  
  public void a(String paramString) {}
  
  public final void a(String paramString, TextEmojiLabel paramTextEmojiLabel, j paramj)
  {
    Context localContext = paramTextEmojiLabel.getContext();
    if (!a()) {
      al.a(this.l, paramTextEmojiLabel, paramString);
    }
    Object localObject1 = getRowsContainer();
    if (localObject1 != null)
    {
      int j = ((jz)localObject1).d(paramj);
      i = j;
      if (j != 0) {}
    }
    for (int i = 1;; i = 0)
    {
      paramTextEmojiLabel.setTextSize(getTextFontSize());
      Object localObject2 = new a(i * 3072, paramString.length());
      localObject1 = new SpannableStringBuilder(paramString);
      yr.a(localContext, this.F, (SpannableStringBuilder)localObject1, paramj.P, paramj.e.b, true);
      com.whatsapp.emoji.c.a((CharSequence)localObject1, localContext, paramTextEmojiLabel.getPaint(), 1.3F, (c.c)localObject2);
      i = ((a)localObject2).a;
      if (i > 0)
      {
        paramString = ((SpannableStringBuilder)localObject1).delete(i + (Character.charCount(paramString.codePointAt(i - 1)) - 1), ((SpannableStringBuilder)localObject1).length());
        localObject1 = new SpannableStringBuilder(getContext().getString(2131297501));
        if (paramj.e.b)
        {
          i = 2131624044;
          ((SpannableStringBuilder)localObject1).setSpan(new d(b.c(localContext, i)), 0, ((SpannableStringBuilder)localObject1).length(), 18);
          paramString.append("... ");
          paramString.append((CharSequence)localObject1);
        }
      }
      for (;;)
      {
        try
        {
          Linkify.addLinks(paramString, 2);
          aa.a(paramString);
          a.a.a.a.d.a(paramString);
          localObject1 = be.a(paramString, URLSpan.class);
          if ((localObject1 != null) && (!((ArrayList)localObject1).isEmpty()))
          {
            if (a(paramj))
            {
              localObject2 = ((ArrayList)localObject1).iterator();
              if (((Iterator)localObject2).hasNext())
              {
                URLSpan localURLSpan = (URLSpan)((Iterator)localObject2).next();
                String str = localURLSpan.getURL();
                if ((str.startsWith("mailto:")) && (aa.a(str))) {
                  continue;
                }
                if (paramj.e.b)
                {
                  i = 2131624044;
                  i = b.c(localContext, i);
                  paramString.setSpan(new ti(this.l, str, i), paramString.getSpanStart(localURLSpan), paramString.getSpanEnd(localURLSpan), paramString.getSpanFlags(localURLSpan));
                  continue;
                  i = 2131624043;
                  break;
                }
                i = 2131624043;
                continue;
              }
            }
            paramj = ((ArrayList)localObject1).iterator();
            if (paramj.hasNext())
            {
              paramString.removeSpan((URLSpan)paramj.next());
              continue;
            }
          }
          paramTextEmojiLabel.setText(be.a(localContext, this.G, a(paramString)), TextView.BufferType.SPANNABLE);
          return;
        }
        catch (Exception localException)
        {
          continue;
        }
        paramString = localException;
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.P == null)
      {
        this.P = new TextView(getContext());
        this.P.setBackgroundResource(2130837769);
        this.P.setGravity(17);
        ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
        localMarginLayoutParams.bottomMargin = getContext().getResources().getDimensionPixelSize(2131361922);
        addView(this.P, localMarginLayoutParams);
        this.h = this.P;
      }
      this.P.setText(com.whatsapp.util.l.e(getContext(), this.a.n).toUpperCase());
      this.P.setTextSize(a(getResources()));
      this.P.setVisibility(0);
      this.r = true;
      return;
    }
    if (this.P != null) {
      this.P.setVisibility(8);
    }
    this.r = false;
  }
  
  public boolean a(j.b paramb)
  {
    return (this.a != null) && (this.a.e.equals(paramb));
  }
  
  public final boolean a(j paramj)
  {
    if (paramj.e.b) {
      return true;
    }
    if (this.B.a(paramj.e.a) == 1) {
      return true;
    }
    cs localcs1 = this.F.a(paramj.e.a);
    if (localcs1.d())
    {
      if (paramj.f != null)
      {
        cs localcs2 = this.F.d(paramj.f);
        cs localcs3 = this.F.d(localcs1.q());
        if (this.w.b != null) {}
        for (paramj = this.w.b() + "@s.whatsapp.net"; (this.J.a(localcs1.t)) || (localcs3.d != null) || (paramj.equals(localcs3.t)) || (localcs2.d != null); paramj = "") {
          return true;
        }
        return false;
      }
      return false;
    }
    if (localcs1.d != null) {
      return true;
    }
    if (paramj.e.a == null) {
      return false;
    }
    int j = paramj.e.a.indexOf("@s.whatsapp.net");
    int i = 0;
    while (i < j)
    {
      if (Character.isDigit(paramj.e.a.charAt(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  protected void b() {}
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
    label86:
    aoa localaoa;
    if (this.Q != null)
    {
      if ((this.a.e.b) || (!qz.e(this.a.e.a))) {
        break label221;
      }
      if ((paramInt <= 1) || (this.a.U != 0L) || (this.a.s != 0) || (com.whatsapp.protocol.m.a(this.a))) {
        this.Q.setVisibility(0);
      }
    }
    else
    {
      localaoa = aoa.a();
      if (!this.a.e.b) {
        break label233;
      }
      paramInt = i.top;
      label111:
      if (!this.a.e.b) {
        break label243;
      }
    }
    int j;
    int k;
    label221:
    label233:
    label243:
    for (int i = i.bottom;; i = j.bottom)
    {
      j = getPaddingLeft();
      k = getPaddingRight();
      switch (this.e)
      {
      default: 
        setPadding(j, paramInt + localaoa.f, k, i + localaoa.f);
        setMinimumHeight((int)getResources().getDimension(2131361938));
        return;
        this.Q.setVisibility(8);
        break label86;
        this.Q.setVisibility(8);
        break label86;
        paramInt = j.top;
        break label111;
      }
    }
    setPadding(j, paramInt + localaoa.f, k, localaoa.g);
    setMinimumHeight((int)getResources().getDimension(2131361939));
    return;
    setPadding(j, localaoa.g, k, localaoa.g);
    setMinimumHeight((int)getResources().getDimension(2131361939));
    return;
    setPadding(j, localaoa.g, k, i + localaoa.f);
    setMinimumHeight((int)getResources().getDimension(2131361939));
  }
  
  public final void b(boolean paramBoolean)
  {
    ScaleAnimation localScaleAnimation;
    if (this.O != null)
    {
      if (!paramBoolean) {
        break label76;
      }
      localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      localScaleAnimation.setInterpolator(new OvershootInterpolator());
      this.O.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public final boolean onPreDraw()
        {
          hy.d(hy.this).getViewTreeObserver().removeOnPreDrawListener(this);
          jz localjz = hy.this.getRowsContainer();
          if (localjz != null) {
            localjz.animateStar(hy.d(hy.this));
          }
          return true;
        }
      });
    }
    for (;;)
    {
      localScaleAnimation.setDuration(500L);
      this.O.startAnimation(localScaleAnimation);
      return;
      label76:
      localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.O.setVisibility(0);
      localScaleAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          hy.d(hy.this).setVisibility(4);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      localScaleAnimation.setInterpolator(new AnticipateInterpolator());
    }
  }
  
  protected void c()
  {
    jz localjz = getRowsContainer();
    if (localjz != null) {
      localjz.a(this.a);
    }
  }
  
  protected void d()
  {
    if (isLongClickable())
    {
      jz localjz = getRowsContainer();
      if (localjz != null) {
        this.q.setSelected(localjz.b(this.a));
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    this.ac.a();
  }
  
  final void e()
  {
    if (this.d) {}
    do
    {
      return;
      if (this.W == null)
      {
        this.W = ((ImageView)findViewById(2131755581));
        if (this.W != null)
        {
          this.W.setImageDrawable(b.a(getContext(), 2130840062));
          this.W.setBackgroundResource(2130840014);
          int i = getContext().getResources().getDimensionPixelSize(2131361997);
          this.W.setPadding(i, i, i, i);
          this.W.setOnClickListener(new com.whatsapp.util.at()
          {
            public final void a(View paramAnonymousView)
            {
              hy.a(hy.this);
            }
          });
          this.W.setOnLongClickListener(this.u);
        }
      }
    } while (this.W == null);
    this.W.setVisibility(0);
  }
  
  final void f()
  {
    if (this.W != null) {
      this.W.setVisibility(8);
    }
  }
  
  public void g() {}
  
  int getBubbleMarginStart()
  {
    int j = 0;
    int k = aoa.a().b;
    if (q()) {}
    for (int i = aoa.a().c;; i = 0)
    {
      if (this.c) {
        j = aoa.a().d;
      }
      return i + k + j;
    }
  }
  
  protected jz getRowsContainer()
  {
    if ((getContext() instanceof jz)) {
      return (jz)getContext();
    }
    return null;
  }
  
  protected int getStarDrawable()
  {
    return 2130840365;
  }
  
  public float getTextFontSize()
  {
    return a(getResources(), this.H);
  }
  
  public final void h()
  {
    Object localObject = getHandler();
    if (localObject == null)
    {
      removeCallbacks(this.aj);
      post(this.aj);
    }
    while (((Handler)localObject).hasMessages(0, this.aj)) {
      return;
    }
    localObject = Message.obtain((Handler)localObject, this.aj);
    ((Message)localObject).what = 0;
    ((Message)localObject).obj = this.aj;
    ((Message)localObject).sendToTarget();
  }
  
  public void i()
  {
    b(this.a);
  }
  
  protected final void j()
  {
    if ((getContext() instanceof Conversation))
    {
      localObject1 = (Conversation)getContext();
      if ((qz.e(this.a.e.a)) && ((!this.a.e.b) || (this.a.d == 6)))
      {
        localObject2 = qz.b(this.a);
        if (localObject2 == null) {
          break label81;
        }
        ((Conversation)localObject1).a(c.a((String)localObject2), null);
      }
    }
    return;
    label81:
    Object localObject2 = new StringBuilder("conversation/getdialogitems/remote_resource is null! ").append(Log.a(this.a));
    if ((av.k()) && (this.a.m == 0)) {}
    for (Object localObject1 = " data=" + this.a.e();; localObject1 = "")
    {
      Log.i((String)localObject1);
      return;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.q != null) {
      this.q.layout(0, 0, getWidth(), getHeight());
    }
    TextView localTextView;
    if ((this.Q != null) && (this.Q.getVisibility() == 0))
    {
      View localView = (View)this.Q.getParent();
      localTextView = (TextView)findViewById(2131755572);
      this.Q.layout(localView.getPaddingLeft(), localView.getPaddingTop(), localView.getWidth() - localView.getPaddingRight(), localView.getPaddingTop() + this.Q.getMeasuredHeight());
      if (this.l.a) {
        localTextView.layout(this.Q.getPaddingLeft(), this.Q.getPaddingTop(), this.Q.getPaddingLeft() + localTextView.getWidth(), this.Q.getPaddingTop() + localTextView.getHeight());
      }
    }
    else
    {
      if (this.R != null)
      {
        paramInt2 = this.R.getDrawable().getIntrinsicWidth();
        paramInt3 = this.R.getDrawable().getIntrinsicHeight();
        paramInt4 = this.g.getTop();
        if (!this.d) {
          break label476;
        }
        paramInt1 = -(int)(aoa.a().a * 8.0F);
        label231:
        paramInt1 = paramInt4 - paramInt1;
        paramInt4 = aoa.a().b + (int)(aoa.a().a * 8.0F);
        if (this.l.d() == this.c) {
          break label486;
        }
        this.R.layout(getWidth() - paramInt2 - paramInt4, paramInt1, getWidth() - paramInt4, paramInt3 + paramInt1);
      }
      label298:
      if (this.W != null)
      {
        if (!this.c) {
          break label512;
        }
        if (this.l.d()) {
          break label507;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label542;
      }
      this.W.layout(this.g.getLeft() - this.W.getMeasuredWidth(), (this.g.getTop() + this.g.getBottom()) / 2 - this.W.getMeasuredHeight() / 2, this.g.getLeft(), (this.g.getTop() + this.g.getBottom()) / 2 + this.W.getMeasuredHeight() / 2);
      return;
      localTextView.layout(this.Q.getWidth() - this.Q.getPaddingRight() - localTextView.getWidth(), this.Q.getPaddingTop(), this.Q.getWidth() - this.Q.getPaddingRight(), this.Q.getPaddingTop() + localTextView.getHeight());
      break;
      label476:
      paramInt1 = getPaddingTop() / 2;
      break label231;
      label486:
      this.R.layout(paramInt4, paramInt1, paramInt2 + paramInt4, paramInt3 + paramInt1);
      break label298;
      label507:
      paramInt1 = 0;
      continue;
      label512:
      if (this.a.e.b == this.l.d()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    label542:
    this.W.layout(this.g.getRight(), (this.g.getTop() + this.g.getBottom()) / 2 - this.W.getMeasuredHeight() / 2, this.g.getRight() + this.W.getMeasuredWidth(), (this.g.getTop() + this.g.getBottom()) / 2 + this.W.getMeasuredHeight() / 2);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.W != null) {
      this.W.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    }
  }
  
  static final class a
    implements c.c
  {
    int a;
    private int b;
    private int c;
    private int d;
    
    public a(int paramInt1, int paramInt2)
    {
      this.c = paramInt1;
      this.b = paramInt2;
    }
    
    public final boolean a(boolean paramBoolean, int paramInt)
    {
      boolean bool = true;
      int j = this.d;
      if (paramBoolean) {}
      for (int i = Math.max(1, 3072 / hy.o());; i = 1)
      {
        this.d = (i + j);
        paramBoolean = bool;
        if (this.d > this.c)
        {
          paramBoolean = bool;
          if (paramInt < this.b - hy.o())
          {
            this.a = paramInt;
            paramBoolean = false;
          }
        }
        return paramBoolean;
      }
    }
  }
  
  static final class b
  {
    public final String a;
    public final String b;
    public final int c;
    
    public b(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = null;
      this.c = paramInt;
    }
    
    public b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = 0;
    }
    
    public final String toString()
    {
      return this.a;
    }
  }
  
  public static final class c
    extends android.support.v4.app.m
  {
    private final br aa = br.a();
    private final com.whatsapp.data.e ab = com.whatsapp.data.e.a();
    
    public static c a(String paramString)
    {
      c localc = new c();
      Bundle localBundle = new Bundle();
      localBundle.putString("jid", paramString);
      localc.f(localBundle);
      return localc;
    }
    
    public final Dialog c(Bundle paramBundle)
    {
      paramBundle = i().getString("jid");
      Object localObject = this.ab.d((String)a.d.a(paramBundle));
      ArrayList localArrayList = new ArrayList();
      if (((cs)localObject).d == null)
      {
        localArrayList.add(new hy.b(m().getString(2131296292), 2131755029));
        localArrayList.add(new hy.b(m().getString(2131296296), 2131755030));
      }
      localArrayList.add(new hy.b(m().getString(2131297166, new Object[] { ((cs)localObject).k() }), 2131755058));
      if (br.b())
      {
        localArrayList.add(new hy.b(m().getString(2131298134, new Object[] { ((cs)localObject).k() }), 2131755086));
        localArrayList.add(new hy.b(m().getString(2131298108, new Object[] { ((cs)localObject).k() }), 2131755085));
      }
      for (;;)
      {
        localObject = new b.a(k());
        ((b.a)localObject).a(new ArrayAdapter(k(), 17367057, localArrayList), if.a(this, localArrayList, paramBundle));
        return ((b.a)localObject).a();
        localArrayList.add(new hy.b(m().getString(2131296373, new Object[] { ((cs)localObject).k() }), 2131755086));
      }
    }
  }
  
  final class d
    extends anx
  {
    public d(int paramInt)
    {
      super(0);
    }
    
    public final void a(View paramView)
    {
      paramView = hy.this.getRowsContainer();
      if (paramView != null)
      {
        int j = paramView.d(hy.this.a);
        int i = j;
        if (j == 0) {
          i = 1;
        }
        paramView.a(hy.this.a, i + 1);
        hy.this.i();
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/hy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */