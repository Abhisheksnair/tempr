package com.whatsapp;

import a.a.a.a.a.a.d;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.f;
import android.support.v4.view.w;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.whatsapp.emoji.h;
import com.whatsapp.protocol.av;
import com.whatsapp.util.az;
import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class EmojiPicker
{
  private static final int[][] A;
  private static final int[][] B;
  private static final int[][] C;
  private static final int[][] D;
  private static final int[][] E;
  private static final g[] G = { new h(h.a(), 0), new g(1, x, 2131755731, 2131755732, 2131296718, 0), new g(2, y, 2131755733, 2131755734, 2131296716, 0), new g(3, z, 2131755735, 2131755736, 2131296715, 0), new g(4, A, 2131755737, 2131755738, 2131296713, 0), new g(5, B, 2131755739, 2131755740, 2131296720, 0), new g(6, C, 2131755741, 2131755742, 2131296717, 0), new g(7, D, 2131755743, 2131755744, 2131296719, 0), new g(8, E, 2131755745, 2131755746, 2131296714, 0) };
  static HandlerThread f;
  static f g;
  static e h;
  static int i;
  private static final SparseArray<SoftReference<Drawable>> v = new SparseArray();
  private static int w;
  private static final int[][] x;
  private static final int[][] y;
  private static final int[][] z;
  private int F = 1;
  private final atv H;
  private final h I;
  private Paint J = new Paint();
  a[] a = new a[G.length];
  ViewPager b;
  View c;
  j d;
  View e;
  c j;
  final Context k;
  ViewTreeObserver.OnGlobalLayoutListener l = new ViewTreeObserver.OnGlobalLayoutListener()
  {
    public final void onGlobalLayout()
    {
      EmojiPicker.c(EmojiPicker.this, EmojiPicker.f(EmojiPicker.this).getWidth() / EmojiPicker.f(EmojiPicker.this).getContext().getResources().getDimensionPixelSize(2131361991));
    }
  };
  private LayoutInflater m;
  private int n;
  private int o;
  private int p;
  private ImageView q;
  private ViewGroup r;
  private View.OnClickListener s;
  private final AbsListView.OnScrollListener t;
  private final boolean u;
  
  static
  {
    i = 500;
    w = 50;
    if (Build.VERSION.SDK_INT >= 12)
    {
      i = ViewConfiguration.getKeyRepeatTimeout();
      w = ViewConfiguration.getKeyRepeatDelay();
    }
    int[] arrayOfInt1 = { 128513 };
    int[] arrayOfInt2 = { 128518 };
    int[] arrayOfInt3 = { 128514 };
    int[] arrayOfInt4 = { 128524 };
    int[] arrayOfInt5 = { 128535 };
    int[] arrayOfInt6 = { 128537 };
    int[] arrayOfInt7 = { 128538 };
    int[] arrayOfInt8 = { 128542 };
    int[] arrayOfInt9 = { 128532 };
    int[] arrayOfInt10 = { 9785 };
    int[] arrayOfInt11 = { 128547 };
    int[] arrayOfInt12 = { 128553 };
    int[] arrayOfInt13 = { 128528 };
    int[] arrayOfInt14 = { 128529 };
    int[] arrayOfInt15 = { 128562 };
    int[] arrayOfInt16 = { 128546 };
    int[] arrayOfInt17 = { 128580 };
    int[] arrayOfInt18 = { 128556 };
    int[] arrayOfInt19 = { 129296 };
    int[] arrayOfInt20 = { 129319 };
    int[] arrayOfInt21 = { 128125 };
    int[] arrayOfInt22 = { 128126 };
    int[] arrayOfInt23 = { 128568 };
    int[] arrayOfInt24 = { 128591 };
    int[] arrayOfInt25 = { 129309 };
    int[] arrayOfInt26 = { 128074 };
    int[] arrayOfInt27 = { 129307 };
    int[] arrayOfInt28 = { 129310 };
    int[] arrayOfInt29 = { 9757 };
    int[] arrayOfInt30 = { 129306 };
    int[] arrayOfInt31 = { 128400 };
    int[] arrayOfInt32 = { 128406 };
    int[] arrayOfInt33 = { 128405 };
    int[] arrayOfInt34 = { 9997 };
    int[] arrayOfInt35 = { 128139 };
    int[] arrayOfInt36 = { 128067 };
    int[] arrayOfInt37 = { 128102 };
    int[] arrayOfInt38 = { 128105 };
    int[] arrayOfInt39 = { 128113, 8205, 9792 };
    int[] arrayOfInt40 = { 128116 };
    int[] arrayOfInt41 = { 128117 };
    int[] arrayOfInt42 = { 128114 };
    int[] arrayOfInt43 = { 128110, 8205, 9792 };
    int[] arrayOfInt44 = { 128119, 8205, 9792 };
    int[] arrayOfInt45 = { 128373, 8205, 9792 };
    int[] arrayOfInt46 = { 128373 };
    int[] arrayOfInt47 = { 128105, 8205, 9877 };
    int[] arrayOfInt48 = { 128105, 8205, 127908 };
    int[] arrayOfInt49 = { 128105, 8205, 127979 };
    int[] arrayOfInt50 = { 128104, 8205, 127981 };
    int[] arrayOfInt51 = { 128104, 8205, 128187 };
    int[] arrayOfInt52 = { 128104, 8205, 128188 };
    int[] arrayOfInt53 = { 128104, 8205, 128300 };
    int[] arrayOfInt54 = { 128104, 8205, 127912 };
    int[] arrayOfInt55 = { 128105, 8205, 9992 };
    int[] arrayOfInt56 = { 128104, 8205, 9992 };
    int[] arrayOfInt57 = { 128104, 8205, 128640 };
    int[] arrayOfInt58 = { 128124 };
    int[] arrayOfInt59 = { 129328 };
    int[] arrayOfInt60 = { 128583, 8205, 9792 };
    int[] arrayOfInt61 = { 128581 };
    int[] arrayOfInt62 = { 128587 };
    int[] arrayOfInt63 = { 128587, 8205, 9794 };
    int[] arrayOfInt64 = { 128135, 8205, 9794 };
    int[] arrayOfInt65 = { 128372 };
    int[] arrayOfInt66 = { 128131 };
    int[] arrayOfInt67 = { 128111, 8205, 9794 };
    int[] arrayOfInt68 = { 128694, 8205, 9792 };
    int[] arrayOfInt69 = { 128109 };
    int[] arrayOfInt70 = { 128108 };
    int[] arrayOfInt71 = { 128105, 8205, 128105, 8205, 128103, 8205, 128103 };
    int[] arrayOfInt72 = { 128104, 8205, 128104, 8205, 128102 };
    int[] arrayOfInt73 = { 128105, 8205, 128102 };
    int[] arrayOfInt74 = { 128105, 8205, 128103 };
    int[] arrayOfInt75 = { 128090 };
    int[] arrayOfInt76 = { 128085 };
    int[] arrayOfInt77 = { 128087 };
    int[] arrayOfInt78 = { 128088 };
    int[] arrayOfInt79 = { 128096 };
    int[] arrayOfInt80 = { 128094 };
    int[] arrayOfInt81 = { 9937 };
    int[] arrayOfInt82 = { 128092 };
    int[] arrayOfInt83 = { 128083 };
    x = new int[][] { { 128512 }, { 128515 }, { 128516 }, arrayOfInt1, arrayOfInt2, { 128517 }, arrayOfInt3, { 129315 }, { 9786 }, { 128522 }, { 128519 }, { 128578 }, { 128579 }, { 128521 }, arrayOfInt4, { 128525 }, { 128536 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 128523 }, { 128540 }, { 128541 }, { 128539 }, { 129297 }, { 129303 }, { 129299 }, { 128526 }, { 129313 }, { 129312 }, { 128527 }, { 128530 }, arrayOfInt8, arrayOfInt9, { 128543 }, { 128533 }, { 128577 }, arrayOfInt10, arrayOfInt11, { 128534 }, { 128555 }, arrayOfInt12, { 128548 }, { 128544 }, { 128545 }, { 128566 }, arrayOfInt13, arrayOfInt14, { 128559 }, { 128550 }, { 128551 }, { 128558 }, arrayOfInt15, { 128565 }, { 128563 }, { 128561 }, { 128552 }, { 128560 }, arrayOfInt16, { 128549 }, { 129316 }, { 128557 }, { 128531 }, { 128554 }, { 128564 }, arrayOfInt17, { 129300 }, { 129317 }, arrayOfInt18, arrayOfInt19, { 129314 }, arrayOfInt20, { 128567 }, { 129298 }, { 129301 }, { 128520 }, { 128127 }, { 128121 }, { 128122 }, { 128169 }, { 128123 }, { 128128 }, { 9760 }, arrayOfInt21, arrayOfInt22, { 129302 }, { 127875 }, { 128570 }, arrayOfInt23, { 128569 }, { 128571 }, { 128572 }, { 128573 }, { 128576 }, { 128575 }, { 128574 }, { 128080 }, { 128588 }, { 128079 }, arrayOfInt24, arrayOfInt25, { 128077 }, { 128078 }, arrayOfInt26, { 9994 }, arrayOfInt27, { 129308 }, arrayOfInt28, { 9996 }, { 129304 }, { 128076 }, { 128072 }, { 128073 }, { 128070 }, { 128071 }, arrayOfInt29, { 9995 }, arrayOfInt30, arrayOfInt31, arrayOfInt32, { 128075 }, { 129305 }, { 128170 }, arrayOfInt33, arrayOfInt34, { 129331 }, { 128133 }, { 128141 }, { 128132 }, arrayOfInt35, { 128068 }, { 128069 }, { 128066 }, arrayOfInt36, { 128099 }, { 128065 }, { 128064 }, { 128483 }, { 128100 }, { 128101 }, { 128118 }, arrayOfInt37, { 128103 }, { 128104 }, arrayOfInt38, arrayOfInt39, { 128113 }, arrayOfInt40, arrayOfInt41, arrayOfInt42, { 128115, 8205, 9792 }, { 128115 }, arrayOfInt43, { 128110 }, arrayOfInt44, { 128119 }, { 128130, 8205, 9792 }, { 128130 }, arrayOfInt45, arrayOfInt46, arrayOfInt47, { 128104, 8205, 9877 }, { 128105, 8205, 127806 }, { 128104, 8205, 127806 }, { 128105, 8205, 127859 }, { 128104, 8205, 127859 }, { 128105, 8205, 127891 }, { 128104, 8205, 127891 }, arrayOfInt48, { 128104, 8205, 127908 }, arrayOfInt49, { 128104, 8205, 127979 }, { 128105, 8205, 127981 }, arrayOfInt50, { 128105, 8205, 128187 }, arrayOfInt51, { 128105, 8205, 128188 }, arrayOfInt52, { 128105, 8205, 128295 }, { 128104, 8205, 128295 }, { 128105, 8205, 128300 }, arrayOfInt53, { 128105, 8205, 127912 }, arrayOfInt54, { 128105, 8205, 128658 }, { 128104, 8205, 128658 }, arrayOfInt55, arrayOfInt56, { 128105, 8205, 128640 }, arrayOfInt57, { 128105, 8205, 9878 }, { 128104, 8205, 9878 }, { 129334 }, { 127877 }, { 128120 }, { 129332 }, { 128112 }, { 129333 }, arrayOfInt58, arrayOfInt59, arrayOfInt60, { 128583 }, { 128129 }, { 128129, 8205, 9794 }, arrayOfInt61, { 128581, 8205, 9794 }, { 128582 }, { 128582, 8205, 9794 }, arrayOfInt62, arrayOfInt63, { 129318, 8205, 9792 }, { 129318, 8205, 9794 }, { 129335, 8205, 9792 }, { 129335, 8205, 9794 }, { 128590 }, { 128590, 8205, 9794 }, { 128589 }, { 128589, 8205, 9794 }, { 128135 }, arrayOfInt64, { 128134 }, { 128134, 8205, 9794 }, arrayOfInt65, arrayOfInt66, { 128378 }, { 128111 }, arrayOfInt67, arrayOfInt68, { 128694 }, { 127939, 8205, 9792 }, { 127939 }, { 128107 }, arrayOfInt69, arrayOfInt70, { 128145 }, { 128105, 8205, 10084, 8205, 128105 }, { 128104, 8205, 10084, 8205, 128104 }, { 128143 }, { 128105, 8205, 10084, 8205, 128139, 8205, 128105 }, { 128104, 8205, 10084, 8205, 128139, 8205, 128104 }, { 128106 }, { 128104, 8205, 128105, 8205, 128103 }, { 128104, 8205, 128105, 8205, 128103, 8205, 128102 }, { 128104, 8205, 128105, 8205, 128102, 8205, 128102 }, { 128104, 8205, 128105, 8205, 128103, 8205, 128103 }, { 128105, 8205, 128105, 8205, 128102 }, { 128105, 8205, 128105, 8205, 128103 }, { 128105, 8205, 128105, 8205, 128103, 8205, 128102 }, { 128105, 8205, 128105, 8205, 128102, 8205, 128102 }, arrayOfInt71, arrayOfInt72, { 128104, 8205, 128104, 8205, 128103 }, { 128104, 8205, 128104, 8205, 128103, 8205, 128102 }, { 128104, 8205, 128104, 8205, 128102, 8205, 128102 }, { 128104, 8205, 128104, 8205, 128103, 8205, 128103 }, arrayOfInt73, arrayOfInt74, { 128105, 8205, 128103, 8205, 128102 }, { 128105, 8205, 128102, 8205, 128102 }, { 128105, 8205, 128103, 8205, 128103 }, { 128104, 8205, 128102 }, { 128104, 8205, 128103 }, { 128104, 8205, 128103, 8205, 128102 }, { 128104, 8205, 128102, 8205, 128102 }, { 128104, 8205, 128103, 8205, 128103 }, arrayOfInt75, arrayOfInt76, { 128086 }, { 128084 }, arrayOfInt77, { 128089 }, arrayOfInt78, arrayOfInt79, { 128097 }, { 128098 }, arrayOfInt80, { 128095 }, { 128082 }, { 127913 }, { 127891 }, { 128081 }, arrayOfInt81, { 127890 }, { 128093 }, { 128091 }, arrayOfInt82, { 128188 }, arrayOfInt83, { 128374 }, { 127746 }, { 9730 } };
    arrayOfInt1 = new int[] { 129409 };
    arrayOfInt2 = new int[] { 128046 };
    arrayOfInt3 = new int[] { 128018 };
    arrayOfInt4 = new int[] { 128039 };
    arrayOfInt5 = new int[] { 128026 };
    arrayOfInt6 = new int[] { 128013 };
    arrayOfInt7 = new int[] { 129425 };
    arrayOfInt8 = new int[] { 128031 };
    arrayOfInt9 = new int[] { 128044 };
    arrayOfInt10 = new int[] { 129416 };
    arrayOfInt11 = new int[] { 128011 };
    arrayOfInt12 = new int[] { 128014 };
    arrayOfInt13 = new int[] { 128016 };
    arrayOfInt14 = new int[] { 127794 };
    arrayOfInt15 = new int[] { 127793 };
    arrayOfInt16 = new int[] { 127807 };
    arrayOfInt17 = new int[] { 127809 };
    arrayOfInt18 = new int[] { 127764 };
    arrayOfInt19 = new int[] { 128165 };
    arrayOfInt20 = new int[] { 9925 };
    arrayOfInt21 = new int[] { 127785 };
    arrayOfInt22 = new int[] { 9924 };
    arrayOfInt23 = new int[] { 10052 };
    arrayOfInt24 = new int[] { 127788 };
    arrayOfInt25 = new int[] { 128166 };
    y = new int[][] { { 128054 }, { 128049 }, { 128045 }, { 128057 }, { 128048 }, { 129418 }, { 128059 }, { 128060 }, { 128040 }, { 128047 }, arrayOfInt1, arrayOfInt2, { 128055 }, { 128061 }, { 128056 }, { 128053 }, { 128584 }, { 128585 }, { 128586 }, arrayOfInt3, { 128020 }, arrayOfInt4, { 128038 }, { 128036 }, { 128035 }, { 128037 }, { 129414 }, { 129413 }, { 129417 }, { 129415 }, { 128058 }, { 128023 }, { 128052 }, { 129412 }, { 128029 }, { 128027 }, { 129419 }, { 128012 }, arrayOfInt5, { 128030 }, { 128028 }, { 128375 }, { 128376 }, { 128034 }, arrayOfInt6, { 129422 }, { 129410 }, { 129408 }, arrayOfInt7, { 128025 }, { 129424 }, { 128032 }, arrayOfInt8, { 128033 }, arrayOfInt9, arrayOfInt10, { 128051 }, arrayOfInt11, { 128010 }, { 128006 }, { 128005 }, { 128003 }, { 128002 }, { 128004 }, { 129420 }, { 128042 }, { 128043 }, { 128024 }, { 129423 }, { 129421 }, arrayOfInt12, { 128022 }, arrayOfInt13, { 128015 }, { 128017 }, { 128021 }, { 128041 }, { 128008 }, { 128019 }, { 129411 }, { 128330 }, { 128007 }, { 128001 }, { 128000 }, { 128063 }, { 128062 }, { 128009 }, { 128050 }, { 127797 }, { 127876 }, arrayOfInt14, { 127795 }, { 127796 }, arrayOfInt15, arrayOfInt16, { 9752 }, { 127808 }, { 127885 }, { 127883 }, { 127811 }, { 127810 }, arrayOfInt17, { 127812 }, { 127806 }, { 128144 }, { 127799 }, { 127801 }, { 129344 }, { 127803 }, { 127804 }, { 127800 }, { 127802 }, { 127758 }, { 127757 }, { 127759 }, { 127765 }, { 127766 }, { 127767 }, { 127768 }, { 127761 }, { 127762 }, { 127763 }, arrayOfInt18, { 127770 }, { 127773 }, { 127774 }, { 127771 }, { 127772 }, { 127769 }, { 128171 }, { 11088 }, { 127775 }, { 10024 }, { 9889 }, { 128293 }, arrayOfInt19, { 9732 }, { 9728 }, { 127780 }, arrayOfInt20, { 127781 }, { 127782 }, { 127752 }, { 9729 }, { 127783 }, { 9928 }, arrayOfInt21, { 127784 }, { 9731 }, arrayOfInt22, arrayOfInt23, arrayOfInt24, { 128168 }, { 127786 }, { 127787 }, { 127754 }, { 128167 }, arrayOfInt25, { 9748 } };
    arrayOfInt1 = new int[] { 127823 };
    arrayOfInt2 = new int[] { 127824 };
    arrayOfInt3 = new int[] { 127818 };
    arrayOfInt4 = new int[] { 127817 };
    arrayOfInt5 = new int[] { 127815 };
    arrayOfInt6 = new int[] { 127816 };
    arrayOfInt7 = new int[] { 127821 };
    arrayOfInt8 = new int[] { 129373 };
    arrayOfInt9 = new int[] { 127814 };
    arrayOfInt10 = new int[] { 129362 };
    arrayOfInt11 = new int[] { 127798 };
    arrayOfInt12 = new int[] { 129364 };
    arrayOfInt13 = new int[] { 129372 };
    arrayOfInt14 = new int[] { 127855 };
    arrayOfInt15 = new int[] { 129360 };
    arrayOfInt16 = new int[] { 127859 };
    arrayOfInt17 = new int[] { 127829 };
    arrayOfInt18 = new int[] { 127839 };
    arrayOfInt19 = new int[] { 129369 };
    arrayOfInt20 = new int[] { 127790 };
    arrayOfInt21 = new int[] { 127791 };
    arrayOfInt22 = new int[] { 127837 };
    arrayOfInt23 = new int[] { 127845 };
    arrayOfInt24 = new int[] { 127843 };
    arrayOfInt25 = new int[] { 127857 };
    arrayOfInt26 = new int[] { 127835 };
    arrayOfInt27 = new int[] { 127833 };
    arrayOfInt28 = new int[] { 127834 };
    arrayOfInt29 = new int[] { 127842 };
    arrayOfInt30 = new int[] { 127846 };
    arrayOfInt31 = new int[] { 127856 };
    arrayOfInt32 = new int[] { 127854 };
    arrayOfInt33 = new int[] { 127851 };
    arrayOfInt34 = new int[] { 127849 };
    arrayOfInt35 = new int[] { 127850 };
    arrayOfInt36 = new int[] { 129371 };
    arrayOfInt37 = new int[] { 127862 };
    arrayOfInt38 = new int[] { 127866 };
    arrayOfInt39 = new int[] { 127867 };
    arrayOfInt40 = new int[] { 127864 };
    arrayOfInt41 = new int[] { 127865 };
    arrayOfInt42 = new int[] { 127869 };
    z = new int[][] { arrayOfInt1, { 127822 }, arrayOfInt2, arrayOfInt3, { 127819 }, { 127820 }, arrayOfInt4, arrayOfInt5, { 127827 }, arrayOfInt6, { 127826 }, { 127825 }, arrayOfInt7, arrayOfInt8, { 129361 }, { 127813 }, arrayOfInt9, arrayOfInt10, { 129365 }, { 127805 }, arrayOfInt11, arrayOfInt12, { 127840 }, { 127792 }, arrayOfInt13, arrayOfInt14, arrayOfInt15, { 127838 }, { 129366 }, { 129472 }, { 129370 }, arrayOfInt16, { 129363 }, { 129374 }, { 127844 }, { 127831 }, { 127830 }, arrayOfInt17, { 127789 }, { 127828 }, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, { 129367 }, { 129368 }, arrayOfInt22, { 127836 }, { 127858 }, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, arrayOfInt28, { 127832 }, arrayOfInt29, { 127841 }, { 127847 }, { 127848 }, arrayOfInt30, arrayOfInt31, { 127874 }, arrayOfInt32, { 127853 }, { 127852 }, arrayOfInt33, { 127871 }, arrayOfInt34, arrayOfInt35, arrayOfInt36, { 127868 }, { 9749 }, { 127861 }, arrayOfInt37, arrayOfInt38, arrayOfInt39, { 129346 }, { 127863 }, { 129347 }, arrayOfInt40, arrayOfInt41, { 127870 }, { 129348 }, { 127860 }, arrayOfInt42 };
    arrayOfInt1 = new int[] { 9917 };
    arrayOfInt2 = new int[] { 127936 };
    arrayOfInt3 = new int[] { 127944 };
    arrayOfInt4 = new int[] { 9918 };
    arrayOfInt5 = new int[] { 127934 };
    arrayOfInt6 = new int[] { 127952 };
    arrayOfInt7 = new int[] { 127945 };
    arrayOfInt8 = new int[] { 127921 };
    arrayOfInt9 = new int[] { 127955 };
    arrayOfInt10 = new int[] { 127992 };
    arrayOfInt11 = new int[] { 129349 };
    arrayOfInt12 = new int[] { 127954 };
    arrayOfInt13 = new int[] { 127953 };
    arrayOfInt14 = new int[] { 127951 };
    arrayOfInt15 = new int[] { 9971 };
    arrayOfInt16 = new int[] { 127993 };
    arrayOfInt17 = new int[] { 127907 };
    arrayOfInt18 = new int[] { 129354 };
    arrayOfInt19 = new int[] { 129355 };
    arrayOfInt20 = new int[] { 127935 };
    arrayOfInt21 = new int[] { 9975 };
    arrayOfInt22 = new int[] { 127938 };
    arrayOfInt23 = new int[] { 127947, 8205, 9792 };
    arrayOfInt24 = new int[] { 127947 };
    arrayOfInt25 = new int[] { 129338 };
    arrayOfInt26 = new int[] { 129340, 8205, 9792 };
    arrayOfInt27 = new int[] { 129340, 8205, 9794 };
    arrayOfInt28 = new int[] { 9977, 8205, 9792 };
    arrayOfInt29 = new int[] { 9977 };
    arrayOfInt30 = new int[] { 129342, 8205, 9792 };
    arrayOfInt31 = new int[] { 129342, 8205, 9794 };
    arrayOfInt32 = new int[] { 127948 };
    arrayOfInt33 = new int[] { 127940, 8205, 9792 };
    arrayOfInt34 = new int[] { 127946, 8205, 9792 };
    arrayOfInt35 = new int[] { 127946 };
    arrayOfInt36 = new int[] { 129341, 8205, 9792 };
    arrayOfInt37 = new int[] { 129341, 8205, 9794 };
    arrayOfInt38 = new int[] { 128675, 8205, 9792 };
    arrayOfInt39 = new int[] { 128675 };
    arrayOfInt40 = new int[] { 127943 };
    arrayOfInt41 = new int[] { 128692, 8205, 9792 };
    arrayOfInt42 = new int[] { 128692 };
    arrayOfInt43 = new int[] { 128693, 8205, 9792 };
    arrayOfInt44 = new int[] { 128693 };
    arrayOfInt45 = new int[] { 127933 };
    arrayOfInt46 = new int[] { 127894 };
    arrayOfInt47 = new int[] { 129351 };
    arrayOfInt48 = new int[] { 129352 };
    arrayOfInt49 = new int[] { 129353 };
    arrayOfInt50 = new int[] { 127942 };
    arrayOfInt51 = new int[] { 127989 };
    arrayOfInt52 = new int[] { 127895 };
    arrayOfInt53 = new int[] { 127915 };
    arrayOfInt54 = new int[] { 127903 };
    arrayOfInt55 = new int[] { 127914 };
    arrayOfInt56 = new int[] { 129337, 8205, 9792 };
    arrayOfInt57 = new int[] { 129337, 8205, 9794 };
    arrayOfInt58 = new int[] { 127917 };
    arrayOfInt59 = new int[] { 127912 };
    arrayOfInt60 = new int[] { 127916 };
    arrayOfInt61 = new int[] { 127908 };
    arrayOfInt62 = new int[] { 127911 };
    arrayOfInt63 = new int[] { 127932 };
    arrayOfInt64 = new int[] { 127929 };
    arrayOfInt65 = new int[] { 129345 };
    arrayOfInt66 = new int[] { 127930 };
    arrayOfInt67 = new int[] { 127928 };
    arrayOfInt68 = new int[] { 127922 };
    arrayOfInt69 = new int[] { 127919 };
    arrayOfInt70 = new int[] { 127923 };
    arrayOfInt71 = new int[] { 127918 };
    arrayOfInt72 = new int[] { 127920 };
    A = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, arrayOfInt17, arrayOfInt18, arrayOfInt19, { 9976 }, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, arrayOfInt24, arrayOfInt25, arrayOfInt26, arrayOfInt27, { 129336, 8205, 9792 }, { 129336, 8205, 9794 }, arrayOfInt28, arrayOfInt29, arrayOfInt30, arrayOfInt31, { 127948, 8205, 9792 }, arrayOfInt32, arrayOfInt33, { 127940 }, arrayOfInt34, arrayOfInt35, arrayOfInt36, arrayOfInt37, arrayOfInt38, arrayOfInt39, arrayOfInt40, arrayOfInt41, arrayOfInt42, arrayOfInt43, arrayOfInt44, arrayOfInt45, { 127941 }, arrayOfInt46, arrayOfInt47, arrayOfInt48, arrayOfInt49, arrayOfInt50, arrayOfInt51, arrayOfInt52, arrayOfInt53, arrayOfInt54, arrayOfInt55, arrayOfInt56, arrayOfInt57, arrayOfInt58, arrayOfInt59, arrayOfInt60, arrayOfInt61, arrayOfInt62, arrayOfInt63, arrayOfInt64, arrayOfInt65, { 127927 }, arrayOfInt66, arrayOfInt67, { 127931 }, arrayOfInt68, arrayOfInt69, arrayOfInt70, arrayOfInt71, arrayOfInt72 };
    arrayOfInt1 = new int[] { 128663 };
    arrayOfInt2 = new int[] { 128654 };
    arrayOfInt3 = new int[] { 127950 };
    arrayOfInt4 = new int[] { 128658 };
    arrayOfInt5 = new int[] { 128666 };
    arrayOfInt6 = new int[] { 128667 };
    arrayOfInt7 = new int[] { 128668 };
    arrayOfInt8 = new int[] { 128680 };
    arrayOfInt9 = new int[] { 128660 };
    arrayOfInt10 = new int[] { 128653 };
    arrayOfInt11 = new int[] { 128664 };
    arrayOfInt12 = new int[] { 128662 };
    arrayOfInt13 = new int[] { 128672 };
    arrayOfInt14 = new int[] { 128671 };
    arrayOfInt15 = new int[] { 128643 };
    arrayOfInt16 = new int[] { 128651 };
    arrayOfInt17 = new int[] { 128669 };
    arrayOfInt18 = new int[] { 128644 };
    arrayOfInt19 = new int[] { 128645 };
    arrayOfInt20 = new int[] { 128648 };
    arrayOfInt21 = new int[] { 128646 };
    arrayOfInt22 = new int[] { 128647 };
    arrayOfInt23 = new int[] { 128650 };
    arrayOfInt24 = new int[] { 9992 };
    arrayOfInt25 = new int[] { 128747 };
    arrayOfInt26 = new int[] { 128748 };
    arrayOfInt27 = new int[] { 128752 };
    arrayOfInt28 = new int[] { 128186 };
    arrayOfInt29 = new int[] { 128755 };
    arrayOfInt30 = new int[] { 128674 };
    arrayOfInt31 = new int[] { 128655 };
    arrayOfInt32 = new int[] { 128678 };
    arrayOfInt33 = new int[] { 128677 };
    arrayOfInt34 = new int[] { 128506 };
    arrayOfInt35 = new int[] { 128511 };
    arrayOfInt36 = new int[] { 128509 };
    arrayOfInt37 = new int[] { 9969 };
    arrayOfInt38 = new int[] { 128507 };
    arrayOfInt39 = new int[] { 127755 };
    arrayOfInt40 = new int[] { 127957 };
    arrayOfInt41 = new int[] { 128739 };
    arrayOfInt42 = new int[] { 127959 };
    arrayOfInt43 = new int[] { 127981 };
    arrayOfInt44 = new int[] { 127968 };
    arrayOfInt45 = new int[] { 127960 };
    arrayOfInt46 = new int[] { 127962 };
    arrayOfInt47 = new int[] { 127972 };
    arrayOfInt48 = new int[] { 127974 };
    arrayOfInt49 = new int[] { 127976 };
    arrayOfInt50 = new int[] { 127979 };
    arrayOfInt51 = new int[] { 127977 };
    arrayOfInt52 = new int[] { 9962 };
    arrayOfInt53 = new int[] { 128332 };
    arrayOfInt54 = new int[] { 9961 };
    arrayOfInt55 = new int[] { 127749 };
    arrayOfInt56 = new int[] { 127776 };
    arrayOfInt57 = new int[] { 127879 };
    arrayOfInt58 = new int[] { 127751 };
    arrayOfInt59 = new int[] { 127750 };
    arrayOfInt60 = new int[] { 127961 };
    arrayOfInt61 = new int[] { 127753 };
    arrayOfInt62 = new int[] { 127745 };
    B = new int[][] { arrayOfInt1, { 128661 }, { 128665 }, { 128652 }, arrayOfInt2, arrayOfInt3, { 128659 }, { 128657 }, arrayOfInt4, { 128656 }, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 128756 }, { 128690 }, { 128757 }, { 127949 }, arrayOfInt8, arrayOfInt9, arrayOfInt10, arrayOfInt11, arrayOfInt12, { 128673 }, arrayOfInt13, arrayOfInt14, arrayOfInt15, arrayOfInt16, { 128670 }, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, { 128642 }, arrayOfInt21, arrayOfInt22, arrayOfInt23, { 128649 }, { 128641 }, { 128745 }, arrayOfInt24, arrayOfInt25, arrayOfInt26, { 128640 }, arrayOfInt27, arrayOfInt28, { 128758 }, { 9973 }, { 128741 }, { 128676 }, arrayOfInt29, { 9972 }, arrayOfInt30, { 9875 }, { 128679 }, { 9981 }, arrayOfInt31, arrayOfInt32, arrayOfInt33, arrayOfInt34, arrayOfInt35, arrayOfInt36, { 9970 }, { 128508 }, { 127984 }, { 127983 }, { 127967 }, { 127905 }, { 127906 }, { 127904 }, arrayOfInt37, { 127958 }, { 127965 }, { 9968 }, { 127956 }, arrayOfInt38, arrayOfInt39, { 127964 }, arrayOfInt40, { 9978 }, { 128740 }, arrayOfInt41, arrayOfInt42, arrayOfInt43, arrayOfInt44, { 127969 }, arrayOfInt45, arrayOfInt46, { 127970 }, { 127980 }, { 127971 }, arrayOfInt47, { 127973 }, arrayOfInt48, arrayOfInt49, { 127978 }, arrayOfInt50, arrayOfInt51, { 128146 }, { 127963 }, arrayOfInt52, arrayOfInt53, { 128333 }, { 128331 }, arrayOfInt54, { 128510 }, { 127889 }, { 127966 }, arrayOfInt55, { 127748 }, arrayOfInt56, arrayOfInt57, { 127878 }, arrayOfInt58, arrayOfInt59, arrayOfInt60, { 127747 }, { 127756 }, arrayOfInt61, arrayOfInt62 };
    arrayOfInt1 = new int[] { 128241 };
    arrayOfInt2 = new int[] { 128433 };
    arrayOfInt3 = new int[] { 128190 };
    arrayOfInt4 = new int[] { 127909 };
    arrayOfInt5 = new int[] { 128224 };
    arrayOfInt6 = new int[] { 128180 };
    arrayOfInt7 = new int[] { 9939 };
    arrayOfInt8 = new int[] { 127880 };
    arrayOfInt9 = new int[] { 128235 };
    arrayOfInt10 = new int[] { 128196 };
    arrayOfInt11 = new int[] { 128215 };
    arrayOfInt12 = new int[] { 9986 };
    arrayOfInt13 = new int[] { 128271 };
    arrayOfInt14 = new int[] { 128272 };
    C = new int[][] { { 8986 }, arrayOfInt1, { 128242 }, { 128187 }, { 9000 }, { 128421 }, { 128424 }, arrayOfInt2, { 128434 }, { 128377 }, { 128476 }, { 128189 }, arrayOfInt3, { 128191 }, { 128192 }, { 128252 }, { 128247 }, { 128248 }, { 128249 }, arrayOfInt4, { 128253 }, { 127902 }, { 128222 }, { 9742 }, { 128223 }, arrayOfInt5, { 128250 }, { 128251 }, { 127897 }, { 127898 }, { 127899 }, { 9201 }, { 9202 }, { 9200 }, { 128368 }, { 8987 }, { 9203 }, { 128225 }, { 128267 }, { 128268 }, { 128161 }, { 128294 }, { 128367 }, { 128465 }, { 128738 }, { 128184 }, { 128181 }, arrayOfInt6, { 128182 }, { 128183 }, { 128176 }, { 128179 }, { 128142 }, { 9878 }, { 128295 }, { 128296 }, { 9874 }, { 128736 }, { 9935 }, { 128297 }, { 9881 }, arrayOfInt7, { 128299 }, { 128163 }, { 128298 }, { 128481 }, { 9876 }, { 128737 }, { 128684 }, { 9904 }, { 9905 }, { 127994 }, { 128302 }, { 128255 }, { 128136 }, { 9879 }, { 128301 }, { 128300 }, { 128371 }, { 128138 }, { 128137 }, { 127777 }, { 128701 }, { 128688 }, { 128703 }, { 128705 }, { 128704 }, { 128718 }, { 128273 }, { 128477 }, { 128682 }, { 128715 }, { 128719 }, { 128716 }, { 128444 }, { 128717 }, { 128722 }, { 127873 }, arrayOfInt8, { 127887 }, { 127872 }, { 127882 }, { 127881 }, { 127886 }, { 127982 }, { 127888 }, { 9993 }, { 128233 }, { 128232 }, { 128231 }, { 128140 }, { 128229 }, { 128228 }, { 128230 }, { 127991 }, { 128234 }, arrayOfInt9, { 128236 }, { 128237 }, { 128238 }, { 128239 }, { 128220 }, { 128195 }, arrayOfInt10, { 128209 }, { 128202 }, { 128200 }, { 128201 }, { 128466 }, { 128467 }, { 128198 }, { 128197 }, { 128199 }, { 128451 }, { 128499 }, { 128452 }, { 128203 }, { 128193 }, { 128194 }, { 128450 }, { 128478 }, { 128240 }, { 128211 }, { 128212 }, { 128210 }, { 128213 }, arrayOfInt11, { 128216 }, { 128217 }, { 128218 }, { 128214 }, { 128278 }, { 128279 }, { 128206 }, { 128391 }, { 128208 }, { 128207 }, { 128204 }, { 128205 }, arrayOfInt12, { 128394 }, { 128395 }, { 10002 }, { 128396 }, { 128397 }, { 128221 }, { 9999 }, { 128269 }, { 128270 }, arrayOfInt13, arrayOfInt14, { 128274 }, { 128275 } };
    arrayOfInt1 = new int[] { 10084 };
    arrayOfInt2 = new int[] { 128148 };
    arrayOfInt3 = new int[] { 128158 };
    arrayOfInt4 = new int[] { 128157 };
    arrayOfInt5 = new int[] { 10013 };
    arrayOfInt6 = new int[] { 9766 };
    arrayOfInt7 = new int[] { 127569 };
    arrayOfInt8 = new int[] { 9762 };
    arrayOfInt9 = new int[] { 9763 };
    arrayOfInt10 = new int[] { 128243 };
    arrayOfInt11 = new int[] { 127546 };
    arrayOfInt12 = new int[] { 10036 };
    arrayOfInt13 = new int[] { 128174 };
    arrayOfInt14 = new int[] { 12953 };
    arrayOfInt15 = new int[] { 127344 };
    arrayOfInt16 = new int[] { 10060 };
    arrayOfInt17 = new int[] { 128286 };
    arrayOfInt18 = new int[] { 10069 };
    arrayOfInt19 = new int[] { 12349 };
    arrayOfInt20 = new int[] { 9888 };
    arrayOfInt21 = new int[] { 128164 };
    arrayOfInt22 = new int[] { 128702 };
    arrayOfInt23 = new int[] { 127359 };
    arrayOfInt24 = new int[] { 128698 };
    arrayOfInt25 = new int[] { 127910 };
    arrayOfInt26 = new int[] { 127385 };
    arrayOfInt27 = new int[] { 127378 };
    arrayOfInt28 = new int[] { 55, 8419 };
    arrayOfInt29 = new int[] { 128287 };
    arrayOfInt30 = new int[] { 42, 8419 };
    arrayOfInt31 = new int[] { 9210 };
    arrayOfInt32 = new int[] { 9193 };
    arrayOfInt33 = new int[] { 9194 };
    arrayOfInt34 = new int[] { 128317 };
    arrayOfInt35 = new int[] { 8600 };
    arrayOfInt36 = new int[] { 8597 };
    arrayOfInt37 = new int[] { 128259 };
    arrayOfInt38 = new int[] { 12336 };
    arrayOfInt39 = new int[] { 10004 };
    arrayOfInt40 = new int[] { 128310 };
    arrayOfInt41 = new int[] { 128306 };
    arrayOfInt42 = new int[] { 9643 };
    arrayOfInt43 = new int[] { 128173 };
    arrayOfInt44 = new int[] { 9824 };
    arrayOfInt45 = new int[] { 127924 };
    arrayOfInt46 = new int[] { 128341 };
    arrayOfInt47 = new int[] { 128342 };
    arrayOfInt48 = new int[] { 128343 };
    arrayOfInt49 = new int[] { 128344 };
    arrayOfInt50 = new int[] { 128351 };
    D = new int[][] { arrayOfInt1, { 128155 }, { 128154 }, { 128153 }, { 128156 }, { 128420 }, arrayOfInt2, { 10083 }, { 128149 }, arrayOfInt3, { 128147 }, { 128151 }, { 128150 }, { 128152 }, arrayOfInt4, { 128159 }, { 9774 }, arrayOfInt5, { 9770 }, { 128329 }, { 9784 }, { 10017 }, { 128303 }, { 128334 }, { 9775 }, arrayOfInt6, { 128720 }, { 9934 }, { 9800 }, { 9801 }, { 9802 }, { 9803 }, { 9804 }, { 9805 }, { 9806 }, { 9807 }, { 9808 }, { 9809 }, { 9810 }, { 9811 }, { 127380 }, { 9883 }, arrayOfInt7, arrayOfInt8, arrayOfInt9, { 128244 }, arrayOfInt10, { 127542 }, { 127514 }, { 127544 }, arrayOfInt11, { 127543 }, arrayOfInt12, { 127386 }, arrayOfInt13, { 127568 }, arrayOfInt14, { 12951 }, { 127540 }, { 127541 }, { 127545 }, { 127538 }, arrayOfInt15, { 127345 }, { 127374 }, { 127377 }, { 127358 }, { 127384 }, arrayOfInt16, { 11093 }, { 128721 }, { 9940 }, { 128219 }, { 128683 }, { 128175 }, { 128162 }, { 9832 }, { 128695 }, { 128687 }, { 128691 }, { 128689 }, arrayOfInt17, { 128245 }, { 128685 }, { 10071 }, arrayOfInt18, { 10067 }, { 10068 }, { 8252 }, { 8265 }, { 128261 }, { 128262 }, arrayOfInt19, arrayOfInt20, { 128696 }, { 128305 }, { 9884 }, { 128304 }, { 9851 }, { 9989 }, { 127535 }, { 128185 }, { 10055 }, { 10035 }, { 10062 }, { 127760 }, { 128160 }, { 9410 }, { 127744 }, arrayOfInt21, { 127975 }, arrayOfInt22, { 9855 }, arrayOfInt23, { 127539 }, { 127490 }, { 128706 }, { 128707 }, { 128708 }, { 128709 }, { 128697 }, arrayOfInt24, { 128700 }, { 128699 }, { 128686 }, arrayOfInt25, { 128246 }, { 127489 }, { 128291 }, { 8505 }, { 128292 }, { 128289 }, { 128288 }, { 127382 }, { 127383 }, arrayOfInt26, arrayOfInt27, { 127381 }, { 127379 }, { 48, 8419 }, { 49, 8419 }, { 50, 8419 }, { 51, 8419 }, { 52, 8419 }, { 53, 8419 }, { 54, 8419 }, arrayOfInt28, { 56, 8419 }, { 57, 8419 }, arrayOfInt29, { 128290 }, { 35, 8419 }, arrayOfInt30, { 9654 }, { 9208 }, { 9199 }, { 9209 }, arrayOfInt31, { 9197 }, { 9198 }, arrayOfInt32, arrayOfInt33, { 9195 }, { 9196 }, { 9664 }, { 128316 }, arrayOfInt34, { 10145 }, { 11013 }, { 11014 }, { 11015 }, { 8599 }, arrayOfInt35, { 8601 }, { 8598 }, arrayOfInt36, { 8596 }, { 8618 }, { 8617 }, { 10548 }, { 10549 }, { 128256 }, { 128257 }, { 128258 }, { 128260 }, arrayOfInt37, { 127925 }, { 127926 }, { 10133 }, { 10134 }, { 10135 }, { 10006 }, { 128178 }, { 128177 }, { 8482 }, { 169 }, { 174 }, arrayOfInt38, { 10160 }, { 10175 }, { 128282 }, { 128281 }, { 128283 }, { 128285 }, { 128284 }, arrayOfInt39, { 9745 }, { 128280 }, { 9898 }, { 9899 }, { 128308 }, { 128309 }, { 128314 }, { 128315 }, { 128312 }, { 128313 }, arrayOfInt40, { 128311 }, { 128307 }, arrayOfInt41, { 9642 }, arrayOfInt42, { 9726 }, { 9725 }, { 9724 }, { 9723 }, { 11035 }, { 11036 }, { 128264 }, { 128263 }, { 128265 }, { 128266 }, { 128276 }, { 128277 }, { 128227 }, { 128226 }, { 128065, 8205, 128488 }, { 128172 }, arrayOfInt43, { 128495 }, arrayOfInt44, { 9827 }, { 9829 }, { 9830 }, { 127183 }, arrayOfInt45, { 126980 }, { 128336 }, { 128337 }, { 128338 }, { 128339 }, { 128340 }, arrayOfInt46, arrayOfInt47, arrayOfInt48, arrayOfInt49, { 128345 }, { 128346 }, { 128347 }, { 128348 }, { 128349 }, { 128350 }, arrayOfInt50, { 128352 }, { 128353 }, { 128354 }, { 128355 }, { 128356 }, { 128357 }, { 128358 }, { 128359 } };
    arrayOfInt1 = new int[] { 128681 };
    arrayOfInt2 = new int[] { 127462, 127485 };
    arrayOfInt3 = new int[] { 127462, 127473 };
    arrayOfInt4 = new int[] { 127462, 127476 };
    arrayOfInt5 = new int[] { 127462, 127470 };
    arrayOfInt6 = new int[] { 127462, 127468 };
    arrayOfInt7 = new int[] { 127462, 127484 };
    arrayOfInt8 = new int[] { 127463, 127480 };
    arrayOfInt9 = new int[] { 127463, 127469 };
    arrayOfInt10 = new int[] { 127463, 127486 };
    arrayOfInt11 = new int[] { 127463, 127487 };
    arrayOfInt12 = new int[] { 127463, 127481 };
    arrayOfInt13 = new int[] { 127470, 127476 };
    arrayOfInt14 = new int[] { 127463, 127475 };
    arrayOfInt15 = new int[] { 127464, 127474 };
    arrayOfInt16 = new int[] { 127464, 127483 };
    arrayOfInt17 = new int[] { 127463, 127478 };
    arrayOfInt18 = new int[] { 127472, 127474 };
    arrayOfInt19 = new int[] { 127464, 127468 };
    arrayOfInt20 = new int[] { 127464, 127465 };
    arrayOfInt21 = new int[] { 127464, 127470 };
    arrayOfInt22 = new int[] { 127464, 127484 };
    arrayOfInt23 = new int[] { 127465, 127471 };
    arrayOfInt24 = new int[] { 127466, 127466 };
    arrayOfInt25 = new int[] { 127466, 127482 };
    arrayOfInt26 = new int[] { 127467, 127472 };
    arrayOfInt27 = new int[] { 127467, 127476 };
    arrayOfInt28 = new int[] { 127467, 127471 };
    arrayOfInt29 = new int[] { 127467, 127479 };
    arrayOfInt30 = new int[] { 127477, 127467 };
    arrayOfInt31 = new int[] { 127468, 127474 };
    arrayOfInt32 = new int[] { 127468, 127481 };
    arrayOfInt33 = new int[] { 127468, 127484 };
    arrayOfInt34 = new int[] { 127469, 127482 };
    arrayOfInt35 = new int[] { 127470, 127466 };
    arrayOfInt36 = new int[] { 127471, 127476 };
    arrayOfInt37 = new int[] { 127472, 127466 };
    arrayOfInt38 = new int[] { 127485, 127472 };
    arrayOfInt39 = new int[] { 127472, 127468 };
    arrayOfInt40 = new int[] { 127473, 127463 };
    arrayOfInt41 = new int[] { 127473, 127480 };
    arrayOfInt42 = new int[] { 127473, 127486 };
    arrayOfInt43 = new int[] { 127473, 127481 };
    arrayOfInt44 = new int[] { 127474, 127472 };
    arrayOfInt45 = new int[] { 127474, 127468 };
    arrayOfInt46 = new int[] { 127474, 127478 };
    arrayOfInt47 = new int[] { 127474, 127465 };
    arrayOfInt48 = new int[] { 127474, 127480 };
    arrayOfInt49 = new int[] { 127474, 127462 };
    arrayOfInt50 = new int[] { 127474, 127487 };
    arrayOfInt51 = new int[] { 127474, 127474 };
    arrayOfInt52 = new int[] { 127475, 127473 };
    arrayOfInt53 = new int[] { 127475, 127466 };
    arrayOfInt54 = new int[] { 127475, 127482 };
    arrayOfInt55 = new int[] { 127477, 127466 };
    arrayOfInt56 = new int[] { 127477, 127475 };
    arrayOfInt57 = new int[] { 127478, 127462 };
    arrayOfInt58 = new int[] { 127484, 127480 };
    arrayOfInt59 = new int[] { 127480, 127481 };
    arrayOfInt60 = new int[] { 127479, 127480 };
    arrayOfInt61 = new int[] { 127480, 127473 };
    arrayOfInt62 = new int[] { 127480, 127468 };
    arrayOfInt63 = new int[] { 127480, 127470 };
    arrayOfInt64 = new int[] { 127480, 127469 };
    arrayOfInt65 = new int[] { 127480, 127486 };
    arrayOfInt66 = new int[] { 127481, 127484 };
    arrayOfInt67 = new int[] { 127481, 127471 };
    arrayOfInt68 = new int[] { 127481, 127476 };
    arrayOfInt69 = new int[] { 127481, 127481 };
    arrayOfInt70 = new int[] { 127481, 127474 };
    arrayOfInt71 = new int[] { 127462, 127466 };
    arrayOfInt72 = new int[] { 127482, 127487 };
    arrayOfInt73 = new int[] { 127483, 127466 };
    arrayOfInt74 = new int[] { 127483, 127475 };
    arrayOfInt75 = new int[] { 127485, 127484 };
    E = new int[][] { { 127987 }, { 127988 }, { 127937 }, arrayOfInt1, { 127987, 8205, 127752 }, { 127462, 127467 }, arrayOfInt2, arrayOfInt3, { 127465, 127487 }, { 127462, 127480 }, { 127462, 127465 }, arrayOfInt4, arrayOfInt5, { 127462, 127478 }, arrayOfInt6, { 127462, 127479 }, { 127462, 127474 }, arrayOfInt7, { 127462, 127482 }, { 127462, 127481 }, { 127462, 127487 }, arrayOfInt8, arrayOfInt9, { 127463, 127465 }, { 127463, 127463 }, arrayOfInt10, { 127463, 127466 }, arrayOfInt11, { 127463, 127471 }, { 127463, 127474 }, arrayOfInt12, { 127463, 127476 }, { 127463, 127462 }, { 127463, 127484 }, { 127463, 127479 }, arrayOfInt13, { 127483, 127468 }, arrayOfInt14, { 127463, 127468 }, { 127463, 127467 }, { 127463, 127470 }, { 127472, 127469 }, arrayOfInt15, { 127464, 127462 }, { 127470, 127464 }, arrayOfInt16, arrayOfInt17, { 127472, 127486 }, { 127464, 127467 }, { 127481, 127465 }, { 127464, 127473 }, { 127464, 127475 }, { 127464, 127485 }, { 127464, 127464 }, { 127464, 127476 }, arrayOfInt18, arrayOfInt19, arrayOfInt20, { 127464, 127472 }, { 127464, 127479 }, arrayOfInt21, { 127469, 127479 }, { 127464, 127482 }, arrayOfInt22, { 127464, 127486 }, { 127464, 127487 }, { 127465, 127472 }, arrayOfInt23, { 127465, 127474 }, { 127465, 127476 }, { 127466, 127464 }, { 127466, 127468 }, { 127480, 127483 }, { 127468, 127478 }, { 127466, 127479 }, arrayOfInt24, { 127466, 127481 }, arrayOfInt25, arrayOfInt26, arrayOfInt27, arrayOfInt28, { 127467, 127470 }, arrayOfInt29, { 127468, 127467 }, arrayOfInt30, { 127481, 127467 }, { 127468, 127462 }, arrayOfInt31, { 127468, 127466 }, { 127465, 127466 }, { 127468, 127469 }, { 127468, 127470 }, { 127468, 127479 }, { 127468, 127473 }, { 127468, 127465 }, { 127468, 127477 }, { 127468, 127482 }, arrayOfInt32, { 127468, 127468 }, { 127468, 127475 }, arrayOfInt33, { 127468, 127486 }, { 127469, 127481 }, { 127469, 127475 }, { 127469, 127472 }, arrayOfInt34, { 127470, 127480 }, { 127470, 127475 }, { 127470, 127465 }, { 127470, 127479 }, { 127470, 127478 }, arrayOfInt35, { 127470, 127474 }, { 127470, 127473 }, { 127470, 127481 }, { 127471, 127474 }, { 127471, 127477 }, { 127884 }, { 127471, 127466 }, arrayOfInt36, { 127472, 127487 }, arrayOfInt37, { 127472, 127470 }, arrayOfInt38, { 127472, 127484 }, arrayOfInt39, { 127473, 127462 }, { 127473, 127483 }, arrayOfInt40, arrayOfInt41, { 127473, 127479 }, arrayOfInt42, { 127473, 127470 }, arrayOfInt43, { 127473, 127482 }, { 127474, 127476 }, arrayOfInt44, arrayOfInt45, { 127474, 127484 }, { 127474, 127486 }, { 127474, 127483 }, { 127474, 127473 }, { 127474, 127481 }, { 127474, 127469 }, arrayOfInt46, { 127474, 127479 }, { 127474, 127482 }, { 127486, 127481 }, { 127474, 127485 }, { 127467, 127474 }, arrayOfInt47, { 127474, 127464 }, { 127474, 127475 }, { 127474, 127466 }, arrayOfInt48, arrayOfInt49, arrayOfInt50, arrayOfInt51, { 127475, 127462 }, { 127475, 127479 }, { 127475, 127477 }, arrayOfInt52, { 127475, 127464 }, { 127475, 127487 }, { 127475, 127470 }, arrayOfInt53, { 127475, 127468 }, arrayOfInt54, { 127475, 127467 }, { 127472, 127477 }, { 127474, 127477 }, { 127475, 127476 }, { 127476, 127474 }, { 127477, 127472 }, { 127477, 127484 }, { 127477, 127480 }, { 127477, 127462 }, { 127477, 127468 }, { 127477, 127486 }, arrayOfInt55, { 127477, 127469 }, arrayOfInt56, { 127477, 127473 }, { 127477, 127481 }, { 127477, 127479 }, arrayOfInt57, { 127479, 127466 }, { 127479, 127476 }, { 127479, 127482 }, { 127479, 127484 }, arrayOfInt58, { 127480, 127474 }, arrayOfInt59, { 127480, 127462 }, { 127480, 127475 }, arrayOfInt60, { 127480, 127464 }, arrayOfInt61, arrayOfInt62, { 127480, 127485 }, { 127480, 127472 }, arrayOfInt63, { 127468, 127480 }, { 127480, 127463 }, { 127480, 127476 }, { 127487, 127462 }, { 127472, 127479 }, { 127480, 127480 }, { 127466, 127480 }, { 127473, 127472 }, { 127463, 127473 }, arrayOfInt64, { 127472, 127475 }, { 127473, 127464 }, { 127477, 127474 }, { 127483, 127464 }, { 127480, 127465 }, { 127480, 127479 }, { 127480, 127487 }, { 127480, 127466 }, { 127464, 127469 }, arrayOfInt65, arrayOfInt66, arrayOfInt67, { 127481, 127487 }, { 127481, 127469 }, { 127481, 127473 }, { 127481, 127468 }, { 127481, 127472 }, arrayOfInt68, arrayOfInt69, { 127481, 127475 }, { 127481, 127479 }, arrayOfInt70, { 127481, 127464 }, { 127481, 127483 }, { 127483, 127470 }, { 127482, 127468 }, { 127482, 127462 }, arrayOfInt71, { 127468, 127463 }, { 127482, 127480 }, { 127482, 127486 }, arrayOfInt72, { 127483, 127482 }, { 127483, 127462 }, arrayOfInt73, arrayOfInt74, { 127484, 127467 }, { 127466, 127469 }, { 127486, 127466 }, { 127487, 127474 }, { 127487, 127484 }, { 127485, 127466 }, { 127485, 127480 }, arrayOfInt75, { 127485, 127481 } };
  }
  
  public EmojiPicker(Context paramContext, final pv parampv, h paramh, atv paramatv, ViewGroup paramViewGroup, int paramInt, AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.t = paramOnScrollListener;
    boolean bool;
    if (this.t != null)
    {
      bool = true;
      this.u = bool;
      this.k = paramContext;
      this.I = paramh;
      this.H = paramatv;
      this.r = ((ViewGroup)paramViewGroup.findViewById(2131755728));
      this.a[0] = new a(paramContext, 0);
      if (paramh.d() <= 0) {
        break label296;
      }
    }
    label296:
    for (int i1 = 0;; i1 = 1)
    {
      this.F = i1;
      this.b = ((ViewPager)paramViewGroup.findViewById(2131755748));
      this.b.setAdapter(new i(parampv));
      this.b.a(new ViewPager.f()
      {
        public final void a(int paramAnonymousInt) {}
        
        public final void a(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
        
        public final void b(int paramAnonymousInt)
        {
          final View localView = EmojiPicker.f(EmojiPicker.this).findViewWithTag(Integer.valueOf(EmojiPicker.d(EmojiPicker.this)));
          if (localView != null) {
            ((ListView)localView).setOnScrollListener(null);
          }
          if (parampv.d()) {
            EmojiPicker.a(EmojiPicker.this, paramAnonymousInt);
          }
          for (;;)
          {
            EmojiPicker.b(EmojiPicker.this, EmojiPicker.d(EmojiPicker.this));
            localView = EmojiPicker.f(EmojiPicker.this).findViewWithTag(Integer.valueOf(EmojiPicker.d(EmojiPicker.this)));
            if (localView != null)
            {
              ((ListView)localView).setOnScrollListener(EmojiPicker.e(EmojiPicker.this));
              localView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
              {
                public final boolean onPreDraw()
                {
                  localView.getViewTreeObserver().removeOnPreDrawListener(this);
                  localView.post(op.a(this));
                  return true;
                }
              });
            }
            return;
            EmojiPicker.a(EmojiPicker.this, EmojiPicker.a(EmojiPicker.this).length - 1 - paramAnonymousInt);
          }
        }
      });
      this.m = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
      this.n = paramContext.getResources().getDimensionPixelSize(2131361991);
      this.o = paramContext.getResources().getDimensionPixelSize(2131361990);
      paramh = G;
      int i2 = paramh.length;
      i1 = 0;
      while (i1 < i2)
      {
        paramOnScrollListener = paramh[i1];
        View localView = this.r.findViewById(paramOnScrollListener.c);
        localView.setContentDescription(paramContext.getString(paramOnScrollListener.e));
        localView.setOnClickListener(ol.a(this, parampv, paramOnScrollListener));
        i1 += 1;
      }
      bool = false;
      break;
    }
    if (parampv.d()) {}
    for (i1 = this.F;; i1 = this.a.length - 1 - this.F)
    {
      this.b.a(i1, false);
      b(this.F);
      this.s = om.a(this, paramatv);
      this.q = ((ImageView)paramViewGroup.findViewById(paramInt));
      if (this.q != null)
      {
        paramContext = new Handler(Looper.getMainLooper())
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            if (EmojiPicker.g(EmojiPicker.this) != null)
            {
              EmojiPicker.g(EmojiPicker.this).a();
              sendEmptyMessageDelayed(0, EmojiPicker.f());
            }
          }
        };
        this.q.setClickable(true);
        this.q.setOnTouchListener(on.a(this, paramContext));
        this.q.setImageDrawable(new az(android.support.v4.content.b.a(this.k, 2130839988)));
      }
      this.e = paramViewGroup.findViewById(2131755749);
      this.e.setVisibility(8);
      this.e.findViewById(2131755228).setOnClickListener(oo.a(this));
      return;
    }
  }
  
  static SharedPreferences a()
  {
    return u.a().getSharedPreferences("emoji_modifiers", 0);
  }
  
  public static List<av> a(List<av> paramList)
  {
    Object localObject2 = h.a();
    Object localObject3;
    av localav;
    if ((paramList != null) && (paramList.size() > 0))
    {
      localObject1 = new HashMap(paramList.size());
      localObject3 = paramList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localav = (av)((Iterator)localObject3).next();
        ((HashMap)localObject1).put(localav.c, Float.valueOf(localav.v));
      }
      ((h)localObject2).a((Map)localObject1);
    }
    Object localObject1 = new ArrayList();
    localObject2 = ((h)localObject2).e().entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localav = new av();
      int[] arrayOfInt = (int[])((Map.Entry)localObject3).getKey();
      float f1 = ((Float)((Map.Entry)localObject3).getValue()).floatValue();
      localav.c = new String(arrayOfInt, 0, arrayOfInt.length);
      localav.v = f1;
      paramList.add(localav);
    }
    return (List<av>)localObject1;
  }
  
  static String b(int[] paramArrayOfInt)
  {
    a.d.a(a.a.a.a.d.a(paramArrayOfInt), "must be skin tone");
    int i1 = a.a.a.a.d.c(paramArrayOfInt);
    StringBuilder localStringBuilder = new StringBuilder().append(Integer.toString(paramArrayOfInt[0]));
    if (i1 == 0) {}
    for (paramArrayOfInt = "";; paramArrayOfInt = "_" + Integer.toString(i1)) {
      return paramArrayOfInt;
    }
  }
  
  private void b(int paramInt)
  {
    g[] arrayOfg = G;
    int i2 = arrayOfg.length;
    int i1 = 0;
    if (i1 < i2)
    {
      g localg = arrayOfg[i1];
      View localView = this.r.findViewById(localg.d);
      ImageView localImageView = (ImageView)this.r.findViewById(localg.c);
      if (localImageView != null)
      {
        if (localg.a != paramInt) {
          break label96;
        }
        localImageView.setSelected(true);
        localView.setBackgroundColor(android.support.v4.content.b.c(localView.getContext(), 2131623944));
      }
      for (;;)
      {
        i1 += 1;
        break;
        label96:
        localImageView.setSelected(false);
        localView.setBackgroundColor(0);
      }
    }
  }
  
  public static int c(int[] paramArrayOfInt)
  {
    return a.a.a.a.d.a(new b(paramArrayOfInt));
  }
  
  final void a(d paramd)
  {
    this.d = new j(paramd);
    int[] arrayOfInt1 = new int[2];
    paramd.getLocationOnScreen(arrayOfInt1);
    Object localObject = (Activity)paramd.getContext();
    if (this.c != null) {}
    for (localObject = this.c;; localObject = ((Activity)localObject).getWindow().getDecorView())
    {
      int[] arrayOfInt2 = new int[2];
      ((View)localObject).getLocationOnScreen(arrayOfInt2);
      this.d.showAtLocation((View)localObject, 51, arrayOfInt1[0] - Math.max(0, arrayOfInt2[0]) + paramd.getMeasuredWidth() / 2 - this.d.getContentView().getMeasuredWidth() / 2, arrayOfInt1[1] - Math.max(0, arrayOfInt2[1]) - this.d.getContentView().getMeasuredHeight() - paramd.getContext().getResources().getDimensionPixelSize(2131362088));
      return;
    }
  }
  
  final void a(int[] paramArrayOfInt)
  {
    int i1 = 0;
    this.I.a(paramArrayOfInt);
    if (this.F != 0) {
      this.a[0].notifyDataSetChanged();
    }
    if (this.j != null)
    {
      int i2 = paramArrayOfInt.length;
      while (i1 < i2)
      {
        int i3 = paramArrayOfInt[i1];
        this.j.a(i3);
        i1 += 1;
      }
    }
  }
  
  public final boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    j localj;
    int i1;
    if ((this.d != null) && (this.d.isShowing()))
    {
      localj = this.d;
      int i2 = (int)paramMotionEvent.getX();
      i1 = (int)paramMotionEvent.getY();
      ViewGroup localViewGroup = (ViewGroup)localj.getContentView();
      paramView.getLocationOnScreen(localj.b);
      i2 = localj.b[0] + i2;
      int i3 = i1 + localj.b[1];
      int i4 = localViewGroup.getChildCount();
      paramView = localj.c;
      localj.c = null;
      i1 = 0;
      if (i1 >= i4) {
        break label253;
      }
      View localView = localViewGroup.getChildAt(i1);
      localView.getLocationOnScreen(localj.b);
      if ((i2 > localj.b[0]) && (i2 < localj.b[0] + localView.getWidth()) && (i3 > localj.b[1]) && (i3 < localj.b[1] + localView.getHeight()))
      {
        localView.setPressed(true);
        localj.c = localView;
      }
    }
    for (;;)
    {
      if ((paramView != null) && (paramView != localj.c)) {
        paramView.setPressed(false);
      }
      if ((paramMotionEvent.getAction() == 1) && (localj.c != null)) {
        localj.a(localj.d[i1]);
      }
      return true;
      i1 += 1;
      break;
      return false;
      label253:
      i1 = 0;
    }
  }
  
  public final void b()
  {
    if (this.q != null) {
      this.q.setVisibility(0);
    }
  }
  
  public static class EmojiWeight
    implements Serializable
  {
    private static final long serialVersionUID = 1L;
    @Deprecated
    public int code;
    public int[] emoji;
    @Deprecated
    public int modifier;
    public float weight;
    
    public EmojiWeight(int[] paramArrayOfInt, float paramFloat)
    {
      this.emoji = paramArrayOfInt;
      this.weight = paramFloat;
    }
    
    public boolean compareEmoji(int[] paramArrayOfInt)
    {
      return Arrays.equals(this.emoji, paramArrayOfInt);
    }
  }
  
  final class a
    extends BaseAdapter
  {
    private Context b;
    private int c;
    
    public a(Context paramContext, int paramInt)
    {
      this.b = paramContext;
      this.c = paramInt;
    }
    
    public final int getCount()
    {
      int j = 0;
      if (EmojiPicker.h(EmojiPicker.this) == 0) {
        return 0;
      }
      int k = (EmojiPicker.d()[this.c].a() + EmojiPicker.h(EmojiPicker.this) - 1) / EmojiPicker.h(EmojiPicker.this);
      int i = j;
      if (EmojiPicker.i(EmojiPicker.this))
      {
        i = j;
        if (EmojiPicker.d()[this.c].a() > 0) {
          i = 1;
        }
      }
      return i + k;
    }
    
    public final Object getItem(int paramInt)
    {
      return null;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if ((paramView == null) || (((ViewGroup)paramView).getChildCount() != EmojiPicker.h(EmojiPicker.this)))
      {
        paramViewGroup = new ViewGroup(EmojiPicker.c(EmojiPicker.this))
        {
          protected final void onLayout(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            float f1 = (paramAnonymousInt3 - paramAnonymousInt1) / EmojiPicker.h(EmojiPicker.this);
            paramAnonymousInt3 = getChildCount();
            paramAnonymousInt1 = 0;
            while (paramAnonymousInt1 < paramAnonymousInt3)
            {
              float f2 = paramAnonymousInt1 * f1;
              getChildAt(paramAnonymousInt1).layout((int)f2, 0, (int)(f2 + f1), paramAnonymousInt4 - paramAnonymousInt2);
              paramAnonymousInt1 += 1;
            }
          }
          
          protected final void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
          {
            paramAnonymousInt2 = View.MeasureSpec.getSize(paramAnonymousInt1);
            int i = getChildCount();
            float f1 = paramAnonymousInt2 / EmojiPicker.h(EmojiPicker.this);
            paramAnonymousInt2 = 0;
            while (paramAnonymousInt2 < i)
            {
              float f2 = paramAnonymousInt2 * f1;
              getChildAt(paramAnonymousInt2).measure(View.MeasureSpec.makeMeasureSpec((int)(f2 + f1) - (int)f2, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
              paramAnonymousInt2 += 1;
            }
            setMeasuredDimension(View.MeasureSpec.getSize(paramAnonymousInt1), EmojiPicker.j(EmojiPicker.this));
          }
        };
        i = 0;
        for (;;)
        {
          paramView = paramViewGroup;
          if (i >= EmojiPicker.h(EmojiPicker.this)) {
            break;
          }
          paramView = new EmojiPicker.d(EmojiPicker.this, this.b);
          paramView.setLayoutParams(new ViewGroup.LayoutParams(EmojiPicker.j(EmojiPicker.this), EmojiPicker.j(EmojiPicker.this)));
          paramViewGroup.addView(paramView);
          i += 1;
        }
      }
      paramView = (ViewGroup)paramView;
      int i = 0;
      if (i < EmojiPicker.h(EmojiPicker.this))
      {
        paramViewGroup = (EmojiPicker.d)paramView.getChildAt(i);
        int j = EmojiPicker.h(EmojiPicker.this) * paramInt + i;
        if (j < EmojiPicker.d()[this.c].a())
        {
          paramViewGroup.a(EmojiPicker.d()[this.c].a(j));
          paramViewGroup.setBackgroundResource(2130840501);
          paramViewGroup.setClickable(true);
          paramViewGroup.setOnClickListener(EmojiPicker.k(EmojiPicker.this));
          if (a.a.a.a.d.a(EmojiPicker.d()[this.c].a(j))) {
            paramViewGroup.setOnLongClickListener(oq.a(this));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          paramViewGroup.setOnLongClickListener(null);
          continue;
          paramViewGroup.a(null);
          paramViewGroup.setBackgroundDrawable(null);
          paramViewGroup.setClickable(false);
          paramViewGroup.setOnLongClickListener(null);
        }
      }
      paramView.setClickable(false);
      return paramView;
    }
  }
  
  static final class b
    implements com.whatsapp.emoji.b
  {
    int[] a;
    int b;
    
    public b(int[] paramArrayOfInt)
    {
      this.a = paramArrayOfInt;
    }
    
    public final int a()
    {
      if (this.b < this.a.length) {}
      for (int i = this.a[this.b];; i = 0)
      {
        this.b += 1;
        return i;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a();
    
    public abstract void a(int paramInt);
  }
  
  final class d
    extends View
  {
    int a = -1;
    Drawable b;
    private int[] d;
    private boolean e;
    private Path f;
    
    public d(Context paramContext)
    {
      super();
    }
    
    public final void a(int[] paramArrayOfInt)
    {
      if (paramArrayOfInt == null)
      {
        this.d = null;
        this.a = -1;
        this.b = null;
        this.e = false;
      }
      int i;
      do
      {
        do
        {
          return;
          i = EmojiPicker.c(paramArrayOfInt);
        } while (this.a == i);
        this.d = paramArrayOfInt;
        this.a = i;
        this.e = a.a.a.a.d.a(paramArrayOfInt);
        this.b = null;
      } while (i == 0);
      this.b = EmojiPicker.a(i);
      if (this.b == null)
      {
        Message.obtain(EmojiPicker.e(), 0, i, 0, this).sendToTarget();
        return;
      }
      invalidate();
    }
    
    protected final void onDraw(Canvas paramCanvas)
    {
      super.onDraw(paramCanvas);
      if (this.e)
      {
        if (this.f == null) {
          this.f = new Path();
        }
        EmojiPicker.m(EmojiPicker.this).setColor(285212672);
        this.f.reset();
        this.f.moveTo(getWidth() * 9 / 10, getHeight() * 9 / 10);
        this.f.lineTo(getWidth() * 9 / 10, getHeight() * 3 / 4);
        this.f.lineTo(getWidth() * 3 / 4, getHeight() * 9 / 10);
        this.f.lineTo(getWidth() * 9 / 10, getHeight() * 9 / 10);
        this.f.setFillType(Path.FillType.WINDING);
        paramCanvas.drawPath(this.f, EmojiPicker.m(EmojiPicker.this));
      }
      if (this.b != null)
      {
        int i = EmojiPicker.n(EmojiPicker.this);
        int j = EmojiPicker.n(EmojiPicker.this);
        int k = (getWidth() - i) / 2;
        int m = (getHeight() - j) / 2;
        this.b.setBounds(k, m, i + k, j + m);
        this.b.draw(paramCanvas);
      }
    }
  }
  
  static final class e
    extends Handler
  {
    private e(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i;
      if (paramMessage.obj != null)
      {
        i = paramMessage.arg1;
        if (!(paramMessage.obj instanceof Drawable)) {
          break label34;
        }
        EmojiPicker.a(i, (Drawable)paramMessage.obj);
      }
      label34:
      Drawable localDrawable;
      do
      {
        return;
        paramMessage = (EmojiPicker.d)paramMessage.obj;
        localDrawable = (Drawable)paramMessage.getTag();
        EmojiPicker.a(i, localDrawable);
      } while (paramMessage.a != i);
      paramMessage.b = localDrawable;
      paramMessage.invalidate();
    }
  }
  
  static final class f
    extends Handler
  {
    private f(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      EmojiPicker.d locald = (EmojiPicker.d)paramMessage.obj;
      int i = paramMessage.arg1;
      paramMessage = EmojiPicker.a(u.a(), i);
      if (paramMessage != null)
      {
        if (locald != null)
        {
          locald.setTag(paramMessage);
          Message.obtain(EmojiPicker.g(), 0, i, 0, locald).sendToTarget();
        }
      }
      else {
        return;
      }
      Message.obtain(EmojiPicker.g(), 1, i, 0, paramMessage).sendToTarget();
    }
  }
  
  static class g
  {
    final int a;
    final int[][] b;
    final int c;
    final int d;
    final int e;
    
    private g(int paramInt1, int[][] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a = paramInt1;
      this.b = paramArrayOfInt;
      this.c = paramInt2;
      this.d = paramInt3;
      this.e = paramInt4;
    }
    
    public int a()
    {
      return this.b.length;
    }
    
    public int[] a(int paramInt)
    {
      int i;
      if (a.a.a.a.d.a(this.b[paramInt]))
      {
        i = EmojiPicker.c().getInt(EmojiPicker.d(this.b[paramInt]), 0);
        if (i != 0) {
          break label150;
        }
        if (this.b[paramInt].length != 2) {
          break label80;
        }
        i = this.b[paramInt][0];
        this.b[paramInt] = new int[1];
        this.b[paramInt][0] = i;
      }
      label80:
      int j;
      for (;;)
      {
        return this.b[paramInt];
        if (this.b[paramInt].length == 4)
        {
          i = this.b[paramInt][0];
          j = this.b[paramInt][3];
          this.b[paramInt] = new int[3];
          this.b[paramInt][0] = i;
          this.b[paramInt][1] = '‍';
          this.b[paramInt][2] = j;
        }
      }
      label150:
      if (this.b[paramInt].length == 1)
      {
        j = this.b[paramInt][0];
        this.b[paramInt] = new int[2];
        this.b[paramInt][0] = j;
      }
      for (;;)
      {
        this.b[paramInt][1] = i;
        break;
        if (this.b[paramInt].length == 3)
        {
          j = this.b[paramInt][0];
          int k = this.b[paramInt][2];
          this.b[paramInt] = new int[4];
          this.b[paramInt][0] = j;
          this.b[paramInt][2] = '‍';
          this.b[paramInt][3] = k;
        }
      }
    }
  }
  
  static final class h
    extends EmojiPicker.g
  {
    private final h f;
    
    private h(h paramh)
    {
      super(null, 2131755729, 2131755730, 2131296722, (byte)0);
      this.f = paramh;
    }
    
    public final int a()
    {
      return this.f.d();
    }
    
    public final int[] a(int paramInt)
    {
      h localh = this.f;
      localh.b();
      return ((EmojiPicker.EmojiWeight)localh.a.get(paramInt)).emoji;
    }
  }
  
  final class i
    extends w
  {
    private final pv b;
    
    i(pv parampv)
    {
      this.b = parampv;
    }
    
    public final Object a(ViewGroup paramViewGroup, int paramInt)
    {
      View localView = EmojiPicker.b(EmojiPicker.this).inflate(2130903215, null);
      ListView localListView = (ListView)localView.findViewById(16908298);
      int i = paramInt;
      if (!this.b.d()) {
        i = EmojiPicker.a(EmojiPicker.this).length - 1 - paramInt;
      }
      if (EmojiPicker.a(EmojiPicker.this)[i] == null) {
        EmojiPicker.a(EmojiPicker.this)[i] = new EmojiPicker.a(EmojiPicker.this, EmojiPicker.c(EmojiPicker.this), i);
      }
      localListView.setAdapter(EmojiPicker.a(EmojiPicker.this)[i]);
      localListView.setEmptyView(localView.findViewById(16908292));
      localListView.setTag(Integer.valueOf(i));
      if (i == EmojiPicker.d(EmojiPicker.this)) {
        localListView.setOnScrollListener(EmojiPicker.e(EmojiPicker.this));
      }
      paramViewGroup.addView(localView, 0);
      return localView;
    }
    
    public final void a(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
      ((ListView)((View)paramObject).findViewById(16908298)).setOnScrollListener(null);
    }
    
    public final boolean a(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public final int b()
    {
      return EmojiPicker.a(EmojiPicker.this).length;
    }
  }
  
  final class j
    extends PopupWindow
  {
    final EmojiPicker.d a;
    int[] b = new int[2];
    View c;
    final int[][] d;
    
    public j(EmojiPicker.d paramd)
    {
      super(-2, -2);
      this.a = paramd;
      this$1 = (LinearLayout)getContentView();
      EmojiPicker.this.setOrientation(0);
      EmojiPicker.this.setFocusableInTouchMode(true);
      EmojiPicker.this.setFocusable(true);
      int j = paramd.getContext().getResources().getDimensionPixelSize(2131361991);
      int k = (j - paramd.getContext().getResources().getDimensionPixelSize(2131361990)) / 2;
      this.d = a.a.a.a.d.b(EmojiPicker.d.a(paramd));
      int i = 0;
      while (i < this.d.length)
      {
        ImageView localImageView = new ImageView(paramd.getContext());
        localImageView.setLayoutParams(new LinearLayout.LayoutParams(j, j));
        localImageView.setPadding(k, k, k, k);
        int m = a.a.a.a.d.a(new EmojiPicker.b(this.d[i]));
        localImageView.setImageDrawable(com.whatsapp.emoji.d.a(paramd.getContext(), m));
        localImageView.setTag(Integer.valueOf(i));
        localImageView.setOnClickListener(or.a(this));
        localImageView.setBackgroundResource(2130840501);
        EmojiPicker.this.addView(localImageView);
        i += 1;
      }
      EmojiPicker.this.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      setTouchable(true);
      setFocusable(true);
      setOutsideTouchable(true);
      setInputMethodMode(2);
      setBackgroundDrawable(android.support.v4.content.b.a(paramd.getContext(), 2130840428));
      EmojiPicker.this.requestFocus();
      paramd.getParent().requestDisallowInterceptTouchEvent(true);
    }
    
    final void a(int[] paramArrayOfInt)
    {
      EmojiPicker.a(EmojiPicker.this, paramArrayOfInt);
      this.a.a(paramArrayOfInt);
      SharedPreferences.Editor localEditor = EmojiPicker.c().edit();
      String str = EmojiPicker.d(paramArrayOfInt);
      if ((paramArrayOfInt.length == 1) || (paramArrayOfInt.length == 3)) {}
      for (int i = 0;; i = paramArrayOfInt[1])
      {
        localEditor.putInt(str, i).apply();
        this.a.invalidate();
        dismiss();
        return;
      }
    }
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/EmojiPicker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */