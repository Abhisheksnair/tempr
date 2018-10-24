package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.a;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v4.content.b;
import android.support.v4.view.ab;
import android.support.v7.app.b.a;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.whatsapp.camera.CameraActivity;
import com.whatsapp.data.cq;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.data.l;
import com.whatsapp.emoji.c;
import com.whatsapp.emoji.search.EmojiSearchContainer;
import com.whatsapp.emoji.search.i.c;
import com.whatsapp.gif_search.GifSearchContainer;
import com.whatsapp.gif_search.a;
import com.whatsapp.gif_search.f;
import com.whatsapp.location.LocationPicker;
import com.whatsapp.location.LocationPicker2;
import com.whatsapp.location.cc;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.MediaFileUtils;
import com.whatsapp.util.ag;
import com.whatsapp.util.at;
import com.whatsapp.util.az;
import com.whatsapp.util.be;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class MessageReplyActivity
  extends nh
{
  private static final HashMap<j.b, String> Q = new HashMap();
  static final String[] n = { "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION" };
  public static final HashMap<j.b, String> y = new HashMap();
  private ImageButton A;
  private ImageButton B;
  private ImageButton C;
  private View D;
  private final va E = va.a();
  private final com.whatsapp.data.d F = com.whatsapp.data.d.a();
  private final oz G = oz.a();
  private final aoj H = aoj.a();
  private final vp I = vp.a();
  private final com.whatsapp.emoji.h J = com.whatsapp.emoji.h.a();
  private final e K = e.a();
  private final l L = l.a();
  private final ag M = ag.a();
  private final cq N = cq.a();
  private final rh O = rh.a();
  private final cc P = cc.a();
  private final vv.a R = new vv.a()
  {
    public final void a()
    {
      MessageReplyActivity localMessageReplyActivity = MessageReplyActivity.this;
      int i;
      if (vv.i())
      {
        i = 2131297515;
        if (!vv.i()) {
          break label40;
        }
      }
      label40:
      for (int j = 2131297513;; j = 2131297514)
      {
        localMessageReplyActivity.a(i, j, new Object[0]);
        return;
        i = 2131297516;
        break;
      }
    }
    
    public final void b()
    {
      MessageReplyActivity localMessageReplyActivity = MessageReplyActivity.this;
      int i;
      if (vv.i())
      {
        i = 2131297515;
        if (!vv.i()) {
          break label40;
        }
      }
      label40:
      for (int j = 2131297513;; j = 2131297514)
      {
        localMessageReplyActivity.a(i, j, new Object[0]);
        return;
        i = 2131297516;
        break;
      }
    }
    
    public final void c()
    {
      MessageReplyActivity.this.a(2131296307, 2131297418, new Object[0]);
    }
    
    public final void d()
    {
      MessageReplyActivity.this.a(2131296307, 2131297418, new Object[0]);
    }
  };
  private f S;
  private final int[] T = new int[2];
  ImageButton o;
  j p;
  String q;
  public View r;
  public View s;
  MentionableEntry t;
  aqs u;
  a v;
  ac w;
  final aq x = aq.a();
  final EmojiPicker.c z = new EmojiPicker.c()
  {
    public final void a()
    {
      MessageReplyActivity.b(MessageReplyActivity.this).dispatchKeyEvent(new KeyEvent(0, 67));
    }
    
    public final void a(int paramAnonymousInt)
    {
      if (MessageReplyActivity.a(MessageReplyActivity.this).e()) {
        return;
      }
      int i = MessageReplyActivity.b(MessageReplyActivity.this).getSelectionStart();
      int j = MessageReplyActivity.b(MessageReplyActivity.this).getSelectionEnd();
      int k;
      if (i > j)
      {
        k = j;
        j = i;
      }
      for (;;)
      {
        MessageReplyActivity.b(MessageReplyActivity.this).getText().replace(k, j, c.b(paramAnonymousInt));
        if (k > MessageReplyActivity.b(MessageReplyActivity.this).length() - c.a(paramAnonymousInt)) {
          break;
        }
        MessageReplyActivity.b(MessageReplyActivity.this).setSelection(k + c.a(paramAnonymousInt));
        return;
        k = i;
      }
    }
  };
  
  private boolean d(int paramInt)
  {
    if (!this.aP.b())
    {
      RequestPermissionActivity.a(this, 2131297445, 2131297444, paramInt);
      return false;
    }
    return true;
  }
  
  final void c(boolean paramBoolean)
  {
    if (this.x.a(this.q))
    {
      a.a.a.a.d.a(this, 106);
      return;
    }
    this.A.setEnabled(false);
    String str = this.t.getStringText().trim();
    if (!be.b(this, this.aE, str))
    {
      pv.a(this, 2131296401, 1);
      return;
    }
    if (paramBoolean) {
      str = be.b(str);
    }
    for (;;)
    {
      this.H.a(Collections.singletonList(this.q), c.b(str), null, this.p, this.t.getMentions(), false, false);
      l();
      return;
      if (str.codePointCount(0, str.length()) > 65536)
      {
        a.a.a.a.d.a(this, 17);
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.S.a())
    {
      this.D.getLocationOnScreen(this.T);
      if ((paramMotionEvent.getRawY() >= this.T[1]) && (paramMotionEvent.getRawY() < this.T[1] + this.D.getHeight()))
      {
        this.S.a(true);
        return false;
      }
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  final void l()
  {
    pv.a(this, 2131297677, 0);
    if (this.p.a()) {
      amt.a().b(1);
    }
    Q.remove(this.p.e);
    y.remove(this.p.e);
    finish();
  }
  
  final void m()
  {
    if (this.x.a(this.q)) {
      a.a.a.a.d.a(this, 106);
    }
    while ((!RequestPermissionActivity.a(this, this.aP, 30)) || (!this.aI.a(this.R))) {
      return;
    }
    if (vv.f() < aic.s << 10 << 10)
    {
      b_(2131296742);
      return;
    }
    Intent localIntent = new Intent(this, CameraActivity.class);
    localIntent.putExtra("jid", this.q);
    localIntent.putExtra("quoted_message_row_id", this.p.Q);
    localIntent.putExtra("origin", 5);
    startActivityForResult(localIntent, 1);
  }
  
  final void n()
  {
    Q.put(this.p.e, c.b(this.t.getStringText()));
    y.put(this.p.e, yr.a(this.t.getMentions()));
  }
  
  final void o()
  {
    if ((d(35)) && (this.aI.a(this.R))) {
      MediaFileUtils.a(this, this.q, this.p.Q, false);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    label342:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                        } while (paramInt2 != -1);
                        l();
                        return;
                      } while ((paramInt2 != -1) && (paramInt2 != 1000));
                      l();
                      return;
                    } while (paramInt2 != -1);
                    localObject = paramIntent.getStringExtra("file_path");
                    String str = paramIntent.getStringExtra("media_url");
                    Uri localUri;
                    MediaData localMediaData;
                    if ((!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(str)))
                    {
                      localUri = null;
                      localMediaData = new MediaData();
                      if (TextUtils.isEmpty((CharSequence)localObject)) {
                        break label342;
                      }
                      localMediaData.file = new File((String)localObject);
                      localObject = MediaFileUtils.d(localMediaData.file.getAbsolutePath());
                    }
                    for (;;)
                    {
                      if ((localUri != null) || (localMediaData.file != null))
                      {
                        localMediaData.gifAttribution = MediaData.toGifAttribution(paramIntent.getIntExtra("provider", 0));
                        this.H.a(this.I.a(this.q, localMediaData, (byte)13, 0, paramIntent.getStringExtra("caption"), localUri, this.p, null, paramIntent.getStringArrayListExtra("mentions"), false), (byte[])localObject);
                        this.S.a(false);
                      }
                      l();
                      this.v.dismiss();
                      return;
                      localUri = Uri.parse(str);
                      localMediaData.width = paramIntent.getIntExtra("media_width", -1);
                      localMediaData.height = paramIntent.getIntExtra("media_height", -1);
                      localObject = paramIntent.getStringExtra("preview_media_url");
                      if (localObject != null) {
                        localObject = com.whatsapp.gif_search.h.a().a((String)localObject);
                      } else {
                        localObject = null;
                      }
                    }
                  } while (paramInt2 != -1);
                  localObject = paramIntent.getData();
                  if (localObject != null) {
                    this.as.a(this.q, (Uri)localObject, MediaFileUtils.d(this.aE, (Uri)localObject), this.p, this, false);
                  }
                  for (;;)
                  {
                    l();
                    return;
                    paramIntent = paramIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
                    if (paramIntent != null)
                    {
                      paramIntent = paramIntent.iterator();
                      while (paramIntent.hasNext())
                      {
                        localObject = (Uri)paramIntent.next();
                        this.as.a(this.q, (Uri)localObject, MediaFileUtils.d(this.aE, (Uri)localObject), this.p, this, false);
                      }
                    }
                  }
                } while (paramInt2 != -1);
                if (this.aP.a("android.permission.READ_CONTACTS") != 0)
                {
                  Log.w("messagereply/actresult/read_contacts permission denied");
                  return;
                }
                paramIntent = ViewSharedContactArrayActivity.a(this.q, paramIntent.getData(), this.p, false, this.K, this.aE, this);
              } while (paramIntent == null);
              startActivityForResult(paramIntent, 8);
              return;
            } while (paramInt2 != -1);
            Object localObject = paramIntent.getData();
            if (localObject == null)
            {
              Log.w("messagereply/audio/share/failed");
              pv.a(getBaseContext(), 2131297841, 0);
              return;
            }
            MediaFileUtils.a(this.aq, this.E, this.G, this.aE, (Uri)localObject, this, new zl(this, paramIntent));
            return;
          } while (paramInt2 != -1);
          m();
          return;
          r();
          return;
        } while (paramInt2 != -1);
        o();
        return;
      } while (paramInt2 != -1);
      q();
      return;
    } while (paramInt2 != -1);
    p();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    Log.i("messagereply/create");
    super.onCreate(paramBundle);
    setContentView(2130903303);
    paramBundle = (FMessageKey)getIntent().getParcelableExtra("key");
    this.p = this.L.a(paramBundle.a);
    if (this.p == null)
    {
      Log.i("messagereply/message-deleted/" + paramBundle.a);
      pv.a(this, 2131297909, 0);
      finish();
      return;
    }
    final Object localObject1;
    Object localObject2;
    label692:
    int i;
    if (this.p.a())
    {
      paramBundle = this.p.f;
      this.q = paramBundle;
      this.r = ((View)a.d.a(findViewById(2131755446)));
      paramBundle = (View)a.d.a(findViewById(2131755402));
      this.s = ((View)a.d.a(findViewById(2131755961)));
      this.D = findViewById(2131755550);
      this.A = ((ImageButton)a.d.a(findViewById(2131755437)));
      this.o = ((ImageButton)a.d.a(findViewById(2131755561)));
      this.o.setOnTouchListener(zi.a(this));
      this.B = ((ImageButton)a.d.a(findViewById(2131755559)));
      this.B.setVisibility(0);
      this.B.setOnClickListener(zt.a(this));
      this.C = ((ImageButton)a.d.a(findViewById(2131755558)));
      this.C.setVisibility(0);
      this.C.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          if (MessageReplyActivity.d(MessageReplyActivity.this).a(MessageReplyActivity.c(MessageReplyActivity.this)))
          {
            a.a.a.a.d.a(MessageReplyActivity.this, 106);
            return;
          }
          MessageReplyActivity.e(MessageReplyActivity.this);
          MessageReplyActivity.f(MessageReplyActivity.this);
          MessageReplyActivity.h(MessageReplyActivity.this).a(MessageReplyActivity.this, MessageReplyActivity.g(MessageReplyActivity.this), MessageReplyActivity.this.s);
        }
      });
      al.a(this.aq, getLayoutInflater(), 2130903397, (ViewGroup)findViewById(2131755560), true);
      this.u = new aqs(this, this, this.r, this.ao, this.aq, this.E, this.G, this.H, this.I, this.aE, this.x, this.aI, this.M, this.N)
      {
        public final void a()
        {
          MessageReplyActivity.i(MessageReplyActivity.this);
        }
        
        protected final boolean b()
        {
          return MessageReplyActivity.k(MessageReplyActivity.this);
        }
        
        public final void c()
        {
          pv.a(MessageReplyActivity.this, 2131297677, 0);
          amt.a().b(1);
          MessageReplyActivity.s().remove(MessageReplyActivity.j(MessageReplyActivity.this).e);
          MessageReplyActivity.y.remove(MessageReplyActivity.j(MessageReplyActivity.this).e);
          MessageReplyActivity.this.finish();
        }
      };
      this.u.g = this.q;
      this.u.h = this.p;
      this.t = ((MentionableEntry)a.d.a(findViewById(2131755557)));
      this.t.setFilters(new InputFilter[] { zy.a(this) });
      if (Build.VERSION.SDK_INT >= 13)
      {
        localObject1 = new String[1];
        localObject1[0] = "image/gif";
        this.t.setAcceptedMimeTypes((String[])localObject1);
        localObject2 = new tc();
        this.t.setOnCommitContentListener(new zz(this, (tc)localObject2, (String[])localObject1));
      }
      localObject1 = findViewById(2131755552);
      ((View)localObject1).setBackgroundResource(2130840037);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      if (qz.e(this.q))
      {
        this.t.a = ((View)localObject1);
        this.t.setMentionPickerVisibilityChangeListener(new aaa((View)localObject1));
        this.t.a((ViewGroup)findViewById(2131755447), this.q, false, false);
      }
      localObject1 = (String)Q.get(this.p.e);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = yr.a((String)y.get(this.p.e));
        this.t.a((String)localObject1, (Collection)localObject2);
        be.a(this, this.aE, this.t.getEditableText(), this.t.getPaint());
      }
      if (!be.a((CharSequence)localObject1)) {
        break label1335;
      }
      this.o.setVisibility(0);
      this.B.setVisibility(0);
      this.A.setVisibility(8);
      this.A.setImageDrawable(new az(b.a(this, 2130840323)));
      localObject1 = (View)a.d.a(findViewById(2131755551));
      i = Math.max(((View)localObject1).getPaddingLeft(), ((View)localObject1).getPaddingRight());
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      if (!this.aq.d()) {
        break label1364;
      }
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = i;
    }
    for (;;)
    {
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject1 = new TextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          String str = paramAnonymousEditable.toString();
          boolean bool;
          if (!TextUtils.isEmpty(str))
          {
            MessageReplyActivity.l(MessageReplyActivity.this).a(this.a.t, 0);
            be.a(MessageReplyActivity.this, MessageReplyActivity.this.aE, paramAnonymousEditable, MessageReplyActivity.b(MessageReplyActivity.this).getPaint());
            if (TextUtils.getTrimmedLength(str) <= 0) {
              break label226;
            }
            bool = true;
            label64:
            MessageReplyActivity.m(MessageReplyActivity.this).setEnabled(bool);
            if ((MessageReplyActivity.n(MessageReplyActivity.this).getVisibility() != 8) || (bool)) {
              break label231;
            }
            MessageReplyActivity.n(MessageReplyActivity.this).startAnimation(aqs.a(true));
            MessageReplyActivity.n(MessageReplyActivity.this).setVisibility(0);
            MessageReplyActivity.g(MessageReplyActivity.this).startAnimation(Conversation.a(MessageReplyActivity.this.aq.d(), true, false));
            MessageReplyActivity.o(MessageReplyActivity.this).startAnimation(Conversation.a(MessageReplyActivity.this.aq.d(), true));
            MessageReplyActivity.o(MessageReplyActivity.this).setVisibility(0);
            MessageReplyActivity.m(MessageReplyActivity.this).startAnimation(aqs.a(false));
            MessageReplyActivity.m(MessageReplyActivity.this).setVisibility(8);
          }
          label226:
          label231:
          while ((MessageReplyActivity.n(MessageReplyActivity.this).getVisibility() != 0) || (!bool))
          {
            return;
            MessageReplyActivity.l(MessageReplyActivity.this).a(this.a.t);
            break;
            bool = false;
            break label64;
          }
          MessageReplyActivity.n(MessageReplyActivity.this).startAnimation(aqs.a(false));
          MessageReplyActivity.n(MessageReplyActivity.this).setVisibility(8);
          MessageReplyActivity.g(MessageReplyActivity.this).startAnimation(Conversation.a(MessageReplyActivity.this.aq.d(), false, false));
          MessageReplyActivity.o(MessageReplyActivity.this).startAnimation(Conversation.a(MessageReplyActivity.this.aq.d(), false));
          MessageReplyActivity.o(MessageReplyActivity.this).setVisibility(8);
          MessageReplyActivity.m(MessageReplyActivity.this).startAnimation(aqs.a(true));
          MessageReplyActivity.m(MessageReplyActivity.this).setVisibility(0);
        }
        
        public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
        
        public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          al.a(MessageReplyActivity.this.aq, MessageReplyActivity.b(MessageReplyActivity.this), paramAnonymousCharSequence);
        }
      };
      this.t.addTextChangedListener((TextWatcher)localObject1);
      this.t.setOnKeyPreImeListener(new aab(this));
      localObject1 = aac.a(this);
      this.t.setOnEditorActionListener((TextView.OnEditorActionListener)localObject1);
      this.A.setOnClickListener(aad.a(this));
      this.v = new a(this.an, this, this.aq, this.J, this.aE, this.aQ);
      this.v.b = true;
      this.v.a(this.z);
      this.S = new f((GifSearchContainer)findViewById(2131755562), (EmojiSearchContainer)findViewById(2131755563), this.v, this);
      localObject1 = (ImageButton)a.d.a(findViewById(2131755556));
      ((ImageButton)localObject1).setOnClickListener(aae.a(this, (ImageButton)localObject1));
      this.S.a(new zj(this));
      this.S.h = new zk(this);
      this.S.e = new i.c()
      {
        public final void m()
        {
          MessageReplyActivity.p(MessageReplyActivity.this).dismiss();
        }
        
        public final void n()
        {
          MessageReplyActivity.p(MessageReplyActivity.this).a(MessageReplyActivity.this.s, localObject1, MessageReplyActivity.b(MessageReplyActivity.this));
        }
      };
      localObject1 = al.a(this.aq, getLayoutInflater(), 2130903342, null, false);
      localObject2 = (ViewGroup)a.d.a(findViewById(2131755553));
      ((ViewGroup)localObject2).setVisibility(0);
      ((ViewGroup)localObject2).addView((View)localObject1);
      localObject2 = (TextView)((View)localObject1).findViewById(2131756047);
      TextView localTextView1 = (TextView)((View)localObject1).findViewById(2131756048);
      TextView localTextView2 = (TextView)((View)localObject1).findViewById(2131756049);
      float f = hy.b(getResources(), this.aF);
      ((TextView)localObject2).setTextSize(f);
      localTextView1.setTextSize(f);
      localTextView2.setTextSize(f);
      aoa.b((TextView)localObject2);
      aoa.b(localTextView1);
      aoa.b(localTextView2);
      hy.a(this.aq, this.E, this.F, this.K, this.aE, this.aF, this.M, this.O, (View)localObject1, this.q, this.p, null);
      localObject1 = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
      ((Animation)localObject1).setDuration(200L);
      ((Animation)localObject1).setStartOffset(300L);
      ((Animation)localObject1).setFillBefore(true);
      ((Animation)localObject1).setFillAfter(true);
      ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
      this.s.startAnimation((Animation)localObject1);
      localObject1 = new BottomSheetBehavior()
      {
        final int[] entryLocation = new int[2];
        
        public boolean onInterceptTouchEvent(CoordinatorLayout paramAnonymousCoordinatorLayout, View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          boolean bool = super.onInterceptTouchEvent(paramAnonymousCoordinatorLayout, paramAnonymousView, paramAnonymousMotionEvent);
          if ((bool) && (MessageReplyActivity.b(MessageReplyActivity.this).getScrollY() > 0))
          {
            float f1 = paramAnonymousMotionEvent.getRawX();
            float f2 = paramAnonymousMotionEvent.getRawY();
            MessageReplyActivity.b(MessageReplyActivity.this).getLocationOnScreen(this.entryLocation);
            if ((f1 > this.entryLocation[0]) && (f1 < this.entryLocation[0] + MessageReplyActivity.b(MessageReplyActivity.this).getWidth()) && (f2 > this.entryLocation[1]) && (f2 < this.entryLocation[1] + MessageReplyActivity.b(MessageReplyActivity.this).getHeight())) {
              return false;
            }
          }
          return bool;
        }
        
        public boolean onLayoutChild(CoordinatorLayout paramAnonymousCoordinatorLayout, View paramAnonymousView, int paramAnonymousInt)
        {
          super.onLayoutChild(paramAnonymousCoordinatorLayout, paramAnonymousView, paramAnonymousInt);
          ab.e(paramAnonymousView, -paramAnonymousView.getTop());
          return true;
        }
      };
      ((CoordinatorLayout.d)paramBundle.getLayoutParams()).a((CoordinatorLayout.a)localObject1);
      ((BottomSheetBehavior)localObject1).setBottomSheetCallback(new BottomSheetBehavior.a()
      {
        public final void a(View paramAnonymousView, float paramAnonymousFloat)
        {
          if ((paramAnonymousFloat < 0.5F) && (!a.a.a.a.d.a(MessageReplyActivity.this)))
          {
            MessageReplyActivity.q(MessageReplyActivity.this);
            MessageReplyActivity.this.finish();
          }
        }
        
        public final void a(View paramAnonymousView, int paramAnonymousInt)
        {
          if (paramAnonymousInt == 4)
          {
            amt.a().b(2);
            if (!a.a.a.a.d.a(MessageReplyActivity.this))
            {
              MessageReplyActivity.q(MessageReplyActivity.this);
              MessageReplyActivity.this.finish();
            }
          }
        }
      });
      paramBundle.setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          amt.a().b(2);
          MessageReplyActivity.q(MessageReplyActivity.this);
          MessageReplyActivity.this.finish();
        }
      });
      if (this.x.a(this.q)) {
        a.a.a.a.d.a(this, 106);
      }
      a.a.a.a.d.a(this, true);
      return;
      paramBundle = this.p.e.a;
      break;
      label1335:
      this.o.setVisibility(8);
      this.B.setVisibility(8);
      this.A.setVisibility(0);
      break label692;
      label1364:
      ((RelativeLayout.LayoutParams)localObject2).leftMargin = i;
    }
  }
  
  public Dialog onCreateDialog(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    case 106: 
      cs localcs = this.K.d(this.q);
      return new b.a(this).b(getString(2131296403, new Object[] { localcs.a(this) })).a(2131298057, zm.a(this, localcs)).b(2131296398, zn.a(this)).a(zo.a(this)).a();
    }
    return new b.a(this).b(2131296409).a(2131297656, zp.a(this)).b(2131296398, zq.a(this)).a();
  }
  
  public void onDestroy()
  {
    Log.i("messagereply/destroy");
    super.onDestroy();
  }
  
  final void p()
  {
    if ((d(38)) && (this.aI.a(this.R))) {
      MediaFileUtils.a(this, this.q);
    }
  }
  
  final void q()
  {
    if ((d(37)) && (this.aI.a(this.R))) {
      MediaFileUtils.a(this.G, 5, this);
    }
  }
  
  final void r()
  {
    Object localObject;
    if (this.P.c()) {
      localObject = LocationPicker2.class;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = new Intent(this, (Class)localObject);
        ((Intent)localObject).putExtra("jid", this.q);
        ((Intent)localObject).putExtra("quoted_message_row_id", this.p.Q);
        ((Intent)localObject).putExtra("has_number_from_url", false);
        startActivityForResult((Intent)localObject, 2);
        return;
        if (cc.b()) {
          localObject = LocationPicker.class;
        }
      }
      else
      {
        if (this.aP.c())
        {
          this.H.a(this.q, null, this.p, false);
          finish();
          return;
        }
        Log.w("messagereply/attach-location/no activity and no permissions.");
        return;
      }
      localObject = null;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MessageReplyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */