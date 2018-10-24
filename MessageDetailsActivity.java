package com.whatsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.b;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;
import com.whatsapp.data.ab;
import com.whatsapp.data.ac;
import com.whatsapp.data.ad.i;
import com.whatsapp.data.ck;
import com.whatsapp.data.ck.a;
import com.whatsapp.data.cs;
import com.whatsapp.data.e;
import com.whatsapp.protocol.j;
import com.whatsapp.protocol.j.b;
import com.whatsapp.util.Log;
import com.whatsapp.util.at;
import com.whatsapp.wallpaper.g;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MessageDetailsActivity
  extends nh
{
  public static String n = "key_id";
  public static String o = "key_remote_jid";
  private final ac A = ac.a();
  private final ab B = new ab()
  {
    private void d(j paramAnonymousj)
    {
      MessageDetailsActivity.this.runOnUiThread(yy.a(this, paramAnonymousj));
    }
    
    public final void a(j paramAnonymousj, int paramAnonymousInt)
    {
      d(paramAnonymousj);
    }
    
    public final void a(Collection<j> paramAnonymousCollection, Map<String, Integer> paramAnonymousMap)
    {
      paramAnonymousCollection = paramAnonymousCollection.iterator();
      while (paramAnonymousCollection.hasNext()) {
        if (((j)paramAnonymousCollection.next()).e.equals(MessageDetailsActivity.a(MessageDetailsActivity.this).e)) {
          MessageDetailsActivity.this.finish();
        }
      }
    }
    
    public final void b(j paramAnonymousj)
    {
      d(paramAnonymousj);
    }
    
    public final void b(String paramAnonymousString)
    {
      if ((paramAnonymousString != null) && (paramAnonymousString.equals(MessageDetailsActivity.a(MessageDetailsActivity.this).e.a)) && (MessageDetailsActivity.b(MessageDetailsActivity.this).a(MessageDetailsActivity.a(MessageDetailsActivity.this).e) == null)) {
        MessageDetailsActivity.this.finish();
      }
    }
  };
  private final aoj C = aoj.a();
  private final e D = e.a();
  private final g E = g.a();
  private final di F = di.a();
  private final di.e G = this.F.b();
  private final dh H = dh.a();
  private final dh.a I = new dh.a()
  {
    public final void a()
    {
      MessageDetailsActivity.e(MessageDetailsActivity.this).notifyDataSetChanged();
    }
    
    protected final void a(String paramAnonymousString)
    {
      if (MessageDetailsActivity.a(MessageDetailsActivity.this, paramAnonymousString)) {
        MessageDetailsActivity.e(MessageDetailsActivity.this).notifyDataSetChanged();
      }
    }
    
    public final void b(String paramAnonymousString)
    {
      if (MessageDetailsActivity.a(MessageDetailsActivity.this, paramAnonymousString)) {
        MessageDetailsActivity.e(MessageDetailsActivity.this).notifyDataSetChanged();
      }
    }
  };
  private final Runnable J = new Runnable()
  {
    public final void run()
    {
      MessageDetailsActivity.e(MessageDetailsActivity.this).notifyDataSetChanged();
      MessageDetailsActivity.f(MessageDetailsActivity.this);
    }
  };
  protected final jd p = new jd(this.F);
  private j q;
  private BaseAdapter r;
  private final ArrayList<c> s = new ArrayList();
  private long t;
  private ListView u;
  private hy v;
  private final ant w = ant.a();
  private final pv x = pv.a();
  private final ck y = ck.a();
  private final com.whatsapp.data.l z = com.whatsapp.data.l.a();
  
  private void l()
  {
    this.s.clear();
    this.t = Long.MAX_VALUE;
    Iterator localIterator = this.y.a(this.q.e).a.entrySet().iterator();
    int k = 0;
    int i = 0;
    int j = 0;
    long l2;
    long l3;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ad.i locali = (ad.i)localEntry.getValue();
      this.s.add(new c((String)localEntry.getKey(), locali));
      long l1 = locali.a(5);
      l2 = locali.a(13);
      l3 = locali.a(8);
      if (l1 == 0L) {
        break label413;
      }
      this.t = Math.min(this.t, l1);
      j += 1;
    }
    label413:
    for (;;)
    {
      if (l2 != 0L)
      {
        this.t = Math.min(this.t, l2);
        k += 1;
      }
      for (;;)
      {
        if (l3 != 0L)
        {
          this.t = Math.min(this.t, l3);
          i += 1;
        }
        for (;;)
        {
          break;
          if ((qz.e(this.q.e.a)) || (j.b(this.q.e.a)))
          {
            if ((i < this.q.F) && (this.q.s == 2) && (this.q.o == 1)) {
              this.s.add(new d(this.q.F - i, 8));
            }
            if (k < this.q.F) {
              this.s.add(new d(this.q.F - k, 13));
            }
            if (j < this.q.F) {
              this.s.add(new d(this.q.F - j, 5));
            }
          }
          Collections.sort(this.s, new Comparator()
          {
            final ch a = new ch(MessageDetailsActivity.this.getApplicationContext());
            private Map<String, cs> c = new HashMap(MessageDetailsActivity.h(MessageDetailsActivity.this).size());
          });
          if (this.r != null) {
            this.r.notifyDataSetChanged();
          }
          m();
          return;
        }
      }
    }
  }
  
  private void m()
  {
    this.u.removeCallbacks(this.J);
    if (this.t != Long.MAX_VALUE) {
      this.u.postDelayed(this.J, com.whatsapp.util.l.e(this.t) - System.currentTimeMillis() + 1000L);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    switch (paramInt1)
    {
    }
    do
    {
      return;
    } while ((paramInt2 != -1) || (paramIntent == null));
    paramIntent = paramIntent.getStringArrayListExtra("jids");
    this.C.a(this.as, this.q, paramIntent);
    if ((paramIntent.size() == 1) && (!j.c((String)paramIntent.get(0))))
    {
      startActivity(Conversation.a(this.D.d((String)paramIntent.get(0))));
      return;
    }
    pv.a(getBaseContext(), paramIntent);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    final boolean bool = true;
    Log.i("messagedetails/create");
    if (Build.VERSION.SDK_INT >= 11)
    {
      b(9);
      requestWindowFeature(9);
    }
    super.onCreate(paramBundle);
    i().a(true);
    setContentView(2130903299);
    final Object localObject1 = i();
    paramBundle = new ColorDrawable(b.c(this, 2131624091));
    ((android.support.v7.app.a)localObject1).a(paramBundle);
    ((android.support.v7.app.a)localObject1).a();
    localObject1 = getIntent();
    if (localObject1 == null)
    {
      finish();
      return;
    }
    this.q = this.z.a(new j.b(((Intent)localObject1).getStringExtra(o), true, ((Intent)localObject1).getStringExtra(n)));
    if (this.q == null)
    {
      finish();
      return;
    }
    Log.i("messagedetails/" + this.q.e);
    this.u = ((ListView)findViewById(16908298));
    l();
    this.v = this.p.a(this, this.q);
    this.v.setOnLongClickListener(null);
    localObject1 = this.v.findViewById(2131755581);
    if (localObject1 != null) {
      ((View)localObject1).setOnClickListener(new at()
      {
        public final void a(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(MessageDetailsActivity.this, ContactPicker.class);
          paramAnonymousView.putExtra("forward", true);
          paramAnonymousView.putExtra("forward_jid", MessageDetailsActivity.a(MessageDetailsActivity.this).e.a);
          paramAnonymousView.putIntegerArrayListExtra("message_types", new ArrayList(Collections.singleton(Integer.valueOf(Byte.valueOf(MessageDetailsActivity.a(MessageDetailsActivity.this).s).intValue()))));
          if (MessageDetailsActivity.a(MessageDetailsActivity.this).s == 3) {}
          for (long l = MessageDetailsActivity.a(MessageDetailsActivity.this).w * 1000L;; l = 0L)
          {
            paramAnonymousView.putExtra("forward_video_duration", l);
            MessageDetailsActivity.this.startActivityForResult(paramAnonymousView, 2);
            return;
          }
        }
      });
    }
    localObject1 = (ViewGroup)al.a(this.x, getLayoutInflater(), 2130903300, null, false);
    final ViewGroup localViewGroup = (ViewGroup)((ViewGroup)localObject1).findViewById(2131755361);
    localViewGroup.addView(this.v, -1, -2);
    localViewGroup.measure(View.MeasureSpec.makeMeasureSpec(getWindowManager().getDefaultDisplay().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(-2, 0));
    final int i = getWindowManager().getDefaultDisplay().getHeight() / 2;
    if (localViewGroup.getMeasuredHeight() > i)
    {
      if (bool) {
        this.u.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
        {
          public final void onGlobalLayout()
          {
            MessageDetailsActivity.g(MessageDetailsActivity.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
            MessageDetailsActivity.g(MessageDetailsActivity.this).setSelectionFromTop(1, MessageDetailsActivity.this.getResources().getDimensionPixelSize(2131361793) * 3);
          }
        });
      }
      this.u.addHeaderView((View)localObject1, null, false);
      final Object localObject2 = new ImageView(this);
      ((ImageView)localObject2).setImageResource(2130839967);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      this.u.addHeaderView((View)localObject2, null, false);
      localObject2 = new View(this);
      ((View)localObject2).setLayoutParams(new AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(2131361910)));
      this.u.addFooterView((View)localObject2, null, false);
      if ((!qz.e(this.q.e.a)) && (!j.b(this.q.e.a))) {
        break label591;
      }
      this.r = new b();
      label500:
      this.u.setAdapter(this.r);
      localObject2 = this.E.d(this);
      if (localObject2 == null) {
        break label607;
      }
      ((ViewGroup)localObject1).setBackgroundDrawable(new Drawable()
      {
        public final void draw(Canvas paramAnonymousCanvas)
        {
          int k = localObject2.getIntrinsicHeight();
          int m = localObject2.getIntrinsicWidth();
          int j = localObject1.getWidth();
          int i = localObject1.getHeight();
          if (j * k > i * m) {
            i = k * j / m;
          }
          for (;;)
          {
            localObject2.setBounds(0, 0, j, i);
            localObject2.draw(paramAnonymousCanvas);
            return;
            j = m * i / k;
          }
        }
        
        public final int getOpacity()
        {
          return -1;
        }
        
        public final void setAlpha(int paramAnonymousInt) {}
        
        public final void setColorFilter(ColorFilter paramAnonymousColorFilter) {}
      });
    }
    for (;;)
    {
      this.u.setOnScrollListener(new AbsListView.OnScrollListener()
      {
        public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (MessageDetailsActivity.g(MessageDetailsActivity.this).getFirstVisiblePosition() > 0)
          {
            paramBundle.setAlpha(255);
            if ((Build.VERSION.SDK_INT >= 11) && (!bool)) {
              localViewGroup.setTranslationY(0.0F);
            }
          }
          do
          {
            do
            {
              return;
              paramAnonymousAbsListView = MessageDetailsActivity.g(MessageDetailsActivity.this).getChildAt(0);
              if (paramAnonymousAbsListView != null) {
                break;
              }
              paramBundle.setAlpha(0);
            } while ((Build.VERSION.SDK_INT < 11) || (bool));
            localViewGroup.setTranslationY(0.0F);
            return;
            paramAnonymousInt1 = paramAnonymousAbsListView.getTop();
            paramAnonymousInt2 = Math.min(255, -paramAnonymousInt1 * 255 / Math.min(i, paramAnonymousAbsListView.getHeight()));
            paramBundle.setAlpha(paramAnonymousInt2);
          } while ((Build.VERSION.SDK_INT < 11) || (bool));
          localViewGroup.setTranslationY(-paramAnonymousInt1 / 2);
        }
        
        public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
      });
      this.H.registerObserver(this.I);
      this.A.registerObserver(this.B);
      return;
      bool = false;
      break;
      label591:
      this.r = new a((byte)0);
      break label500;
      label607:
      ((ViewGroup)localObject1).setBackgroundResource(2131623999);
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public void onDestroy()
  {
    Log.i("messagedetails/destroy");
    super.onDestroy();
    this.G.a();
    this.p.a();
    yx.i();
    this.u.removeCallbacks(this.J);
    this.H.unregisterObserver(this.I);
    this.A.unregisterObserver(this.B);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return false;
    }
    finish();
    return true;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = al.a(MessageDetailsActivity.k(MessageDetailsActivity.this), MessageDetailsActivity.this.getLayoutInflater(), 2130903301, paramViewGroup, false);
      }
      paramView = ((MessageDetailsActivity.c)MessageDetailsActivity.h(MessageDetailsActivity.this).get(0)).b;
      paramViewGroup = localView.findViewById(2131755944);
      label116:
      TextView localTextView1;
      TextView localTextView2;
      TextView localTextView3;
      if ((MessageDetailsActivity.a(MessageDetailsActivity.this).s == 2) && (MessageDetailsActivity.a(MessageDetailsActivity.this).o == 1))
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup = (TextView)localView.findViewById(2131755946);
        if (MessageDetailsActivity.a(MessageDetailsActivity.this).s != 0) {
          break label286;
        }
        paramInt = 2131297176;
        paramViewGroup.setText(paramInt);
        paramViewGroup = (TextView)localView.findViewById(2131755949);
        localTextView1 = (TextView)localView.findViewById(2131755948);
        localTextView2 = (TextView)localView.findViewById(2131755947);
        localTextView3 = (TextView)localView.findViewById(2131755945);
        paramViewGroup.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, MessageDetailsActivity.a(MessageDetailsActivity.this).n));
        if (paramView.a(5) <= 0L) {
          break label292;
        }
        localTextView1.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, paramView.a(5)));
        label216:
        if (paramView.a(13) <= 0L) {
          break label302;
        }
        localTextView2.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, paramView.a(13)));
      }
      for (;;)
      {
        if (paramView.a(8) <= 0L) {
          break label312;
        }
        localTextView3.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, paramView.a(8)));
        return localView;
        paramViewGroup.setVisibility(8);
        break;
        label286:
        paramInt = 2131297178;
        break label116;
        label292:
        localTextView1.setText("—");
        break label216;
        label302:
        localTextView2.setText("—");
      }
      label312:
      localTextView3.setText("—");
      return localView;
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
  }
  
  final class b
    extends BaseAdapter
  {
    String a;
    View b;
    int c;
    private final int e = MessageDetailsActivity.this.getResources().getInteger(17694721);
    
    b() {}
    
    private void a(int paramInt, View paramView)
    {
      MessageDetailsActivity.c localc = (MessageDetailsActivity.c)MessageDetailsActivity.h(MessageDetailsActivity.this).get(paramInt);
      Object localObject1 = paramView.findViewById(2131755950);
      Object localObject2;
      if ((paramInt == 0) || (localc.a() != ((MessageDetailsActivity.c)MessageDetailsActivity.h(MessageDetailsActivity.this).get(paramInt - 1)).a()))
      {
        ((View)localObject1).setVisibility(0);
        localObject1 = (TextView)paramView.findViewById(2131755951);
        localObject2 = (TextView)paramView.findViewById(2131755952);
        switch (localc.a())
        {
        default: 
          localObject1 = paramView.findViewById(2131755385);
          localObject2 = paramView.findViewById(2131755340);
          if ((paramInt == MessageDetailsActivity.h(MessageDetailsActivity.this).size() - 1) || (localc.a() != ((MessageDetailsActivity.c)MessageDetailsActivity.h(MessageDetailsActivity.this).get(paramInt + 1)).a()))
          {
            ((View)localObject2).setBackgroundResource(2130840429);
            ((View)localObject1).setVisibility(8);
          }
          break;
        }
      }
      TextEmojiLabel localTextEmojiLabel1;
      TextEmojiLabel localTextEmojiLabel2;
      View localView1;
      View localView2;
      View localView3;
      TextView localTextView1;
      TextView localTextView2;
      TextView localTextView3;
      View localView4;
      View localView5;
      View localView6;
      for (;;)
      {
        localObject2 = (ImageView)paramView.findViewById(2131755363);
        localTextEmojiLabel1 = (TextEmojiLabel)paramView.findViewById(2131755397);
        localTextEmojiLabel2 = (TextEmojiLabel)paramView.findViewById(2131755803);
        localObject1 = (TextView)paramView.findViewById(2131755953);
        localView1 = paramView.findViewById(2131755959);
        localView2 = paramView.findViewById(2131755957);
        localView3 = paramView.findViewById(2131755955);
        localTextView1 = (TextView)paramView.findViewById(2131755948);
        localTextView2 = (TextView)paramView.findViewById(2131755947);
        localTextView3 = (TextView)paramView.findViewById(2131755945);
        localView4 = paramView.findViewById(2131755960);
        localView5 = paramView.findViewById(2131755958);
        localView6 = paramView.findViewById(2131755956);
        localView1.setVisibility(8);
        localView2.setVisibility(8);
        localView3.setVisibility(8);
        localView4.setVisibility(8);
        localView5.setVisibility(8);
        localView6.setVisibility(8);
        if (!(localc instanceof MessageDetailsActivity.d)) {
          break label547;
        }
        ((TextView)localObject1).setVisibility(0);
        ((ImageView)localObject2).setVisibility(8);
        localTextEmojiLabel1.setVisibility(8);
        localTextEmojiLabel2.setVisibility(8);
        paramView = (MessageDetailsActivity.d)localc;
        ((TextView)localObject1).setText(String.format(u.a.a(2131230787, paramView.c), new Object[] { Integer.valueOf(paramView.c) }));
        return;
        ((TextView)localObject1).setText(2131297170);
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130840382, 0, 0, 0);
        break;
        if (MessageDetailsActivity.a(MessageDetailsActivity.this).s == 0) {}
        for (int i = 2131297177;; i = 2131297179)
        {
          ((TextView)localObject1).setText(i);
          ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130840381, 0, 0, 0);
          break;
        }
        ((TextView)localObject1).setText(2131297175);
        ((TextView)localObject2).setCompoundDrawablesWithIntrinsicBounds(2130840392, 0, 0, 0);
        break;
        ((View)localObject1).setVisibility(8);
        break;
        ((View)localObject2).setBackgroundResource(2130840431);
        ((View)localObject1).setVisibility(0);
      }
      label547:
      cs localcs = MessageDetailsActivity.i(MessageDetailsActivity.this).d(localc.a);
      ((TextView)localObject1).setVisibility(8);
      ((ImageView)localObject2).setVisibility(0);
      MessageDetailsActivity.j(MessageDetailsActivity.this).a(localcs, (ImageView)localObject2);
      localTextEmojiLabel1.setVisibility(0);
      localTextEmojiLabel1.setContact(localcs);
      if ((localcs.h()) && (!TextUtils.isEmpty(localcs.q)))
      {
        localTextEmojiLabel2.setVisibility(0);
        localTextEmojiLabel2.a("~" + localcs.q);
        if (!localcs.t.equals(this.a)) {
          break label813;
        }
        if (localc.a(5) > 0L)
        {
          localTextView1.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, localc.a(5)));
          localView1.setVisibility(0);
          localView4.setVisibility(0);
        }
        if (localc.a(13) > 0L)
        {
          localTextView2.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, localc.a(13)));
          localView2.setVisibility(0);
          localView5.setVisibility(0);
        }
        if (localc.a(8) > 0L)
        {
          localTextView3.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, localc.a(8)));
          localView3.setVisibility(0);
          localView6.setVisibility(0);
        }
      }
      for (;;)
      {
        paramView.setTag(localcs);
        return;
        localTextEmojiLabel2.setVisibility(8);
        break;
        label813:
        switch (localc.a())
        {
        default: 
          break;
        case 5: 
          localTextView1.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, localc.a(5)));
          localView1.setVisibility(0);
          break;
        case 13: 
          localTextView2.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, localc.a(13)));
          localView2.setVisibility(0);
          break;
        case 8: 
          localTextView3.setText(MessageDetailsActivity.a(MessageDetailsActivity.this, localc.a(8)));
          localView3.setVisibility(0);
        }
      }
    }
    
    final void a(final int paramInt, View paramView, boolean paramBoolean)
    {
      final Object localObject1 = (MessageDetailsActivity.c)MessageDetailsActivity.h(MessageDetailsActivity.this).get(paramInt);
      Object localObject3 = (TextView)paramView.findViewById(2131755948);
      TextView localTextView1 = (TextView)paramView.findViewById(2131755947);
      TextView localTextView2 = (TextView)paramView.findViewById(2131755945);
      View localView1 = paramView.findViewById(2131755960);
      View localView2 = paramView.findViewById(2131755958);
      View localView3 = paramView.findViewById(2131755956);
      View localView4 = paramView.findViewById(2131755959);
      View localView5 = paramView.findViewById(2131755957);
      View localView6 = paramView.findViewById(2131755955);
      Object localObject2 = new ArrayList(6);
      switch (((MessageDetailsActivity.c)localObject1).a())
      {
      default: 
        localObject2 = ((ArrayList)localObject2).iterator();
        label155:
        if (!((Iterator)localObject2).hasNext()) {
          break label616;
        }
        localObject3 = (View)((Iterator)localObject2).next();
        if (paramBoolean)
        {
          localObject1 = new AlphaAnimation(0.0F, 1.0F);
          ((Animation)localObject1).setDuration(this.e);
          ((Animation)localObject1).setStartOffset((0.0F * this.e));
        }
        break;
      }
      for (;;)
      {
        ((View)localObject3).startAnimation((Animation)localObject1);
        break label155;
        ((ArrayList)localObject2).add(localView1);
        if (!MessageDetailsActivity.k(MessageDetailsActivity.this).d()) {
          break;
        }
        if (paramBoolean) {}
        for (localObject1 = new TranslateAnimation(((TextView)localObject3).getWidth() - localView4.getWidth(), 0.0F, 0.0F, 0.0F);; localObject1 = new TranslateAnimation(localView1.getWidth(), 0.0F, 0.0F, 0.0F))
        {
          ((Animation)localObject1).setDuration(this.e);
          ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
          ((TextView)localObject3).startAnimation((Animation)localObject1);
          break;
        }
        ((ArrayList)localObject2).add(localView2);
        ((ArrayList)localObject2).add(localView4);
        ((ArrayList)localObject2).add(localView1);
        if (!MessageDetailsActivity.k(MessageDetailsActivity.this).d()) {
          break;
        }
        if (paramBoolean) {}
        for (localObject1 = new TranslateAnimation(localTextView1.getWidth() - localView5.getWidth(), 0.0F, 0.0F, 0.0F);; localObject1 = new TranslateAnimation(localView2.getWidth(), 0.0F, 0.0F, 0.0F))
        {
          ((Animation)localObject1).setDuration(this.e);
          ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
          localTextView1.startAnimation((Animation)localObject1);
          break;
        }
        ((ArrayList)localObject2).add(localView3);
        ((ArrayList)localObject2).add(localView5);
        ((ArrayList)localObject2).add(localView2);
        ((ArrayList)localObject2).add(localView4);
        ((ArrayList)localObject2).add(localView1);
        if (!MessageDetailsActivity.k(MessageDetailsActivity.this).d()) {
          break;
        }
        if (paramBoolean) {}
        for (localObject1 = new TranslateAnimation(localTextView2.getWidth() - localView6.getWidth(), 0.0F, 0.0F, 0.0F);; localObject1 = new TranslateAnimation(localView3.getWidth(), 0.0F, 0.0F, 0.0F))
        {
          ((Animation)localObject1).setDuration(this.e);
          ((Animation)localObject1).setInterpolator(new DecelerateInterpolator());
          localTextView2.startAnimation((Animation)localObject1);
          break;
        }
        localObject1 = new AlphaAnimation(1.0F, 0.0F);
        ((Animation)localObject1).setDuration(this.e);
        ((Animation)localObject1).setStartOffset((0.0F * this.e));
      }
      label616:
      localObject1 = paramView.findViewById(2131755954);
      final int i = ((View)localObject1).getHeight();
      a(paramInt, paramView);
      ((View)localObject1).measure(View.MeasureSpec.makeMeasureSpec(((View)localObject1).getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramInt = ((View)localObject1).getMeasuredHeight();
      ((View)localObject1).getLayoutParams().height = i;
      paramView = new Animation()
      {
        protected final void applyTransformation(float paramAnonymousFloat, Transformation paramAnonymousTransformation)
        {
          if (paramAnonymousFloat == 1.0F) {}
          for (localObject1.getLayoutParams().height = -2;; localObject1.getLayoutParams().height = (i + (int)((paramInt - i) * paramAnonymousFloat)))
          {
            localObject1.requestLayout();
            return;
          }
        }
        
        public final boolean willChangeBounds()
        {
          return true;
        }
      };
      paramView.setDuration(this.e);
      ((View)localObject1).startAnimation(paramView);
    }
    
    public final int getCount()
    {
      return MessageDetailsActivity.h(MessageDetailsActivity.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return MessageDetailsActivity.h(MessageDetailsActivity.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      View localView = paramView;
      if (paramView == null) {
        localView = al.a(MessageDetailsActivity.k(MessageDetailsActivity.this), MessageDetailsActivity.this.getLayoutInflater(), 2130903302, paramViewGroup, false);
      }
      a(paramInt, localView);
      localView.setOnClickListener(yz.a(this, paramInt));
      return localView;
    }
    
    public final int getViewTypeCount()
    {
      return 1;
    }
    
    public final boolean hasStableIds()
    {
      return true;
    }
  }
  
  static class c
  {
    String a;
    ad.i b;
    
    c(String paramString, ad.i parami)
    {
      this.a = paramString;
      this.b = parami;
    }
    
    int a()
    {
      return this.b.a();
    }
    
    long a(int paramInt)
    {
      return this.b.a(paramInt);
    }
  }
  
  static final class d
    extends MessageDetailsActivity.c
  {
    int c;
    int d;
    
    d(int paramInt1, int paramInt2)
    {
      super(null);
      this.c = paramInt1;
      this.d = paramInt2;
    }
    
    final int a()
    {
      return this.d;
    }
    
    final long a(int paramInt)
    {
      return 0L;
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/MessageDetailsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */