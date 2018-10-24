package com.whatsapp;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.whatsapp.observablelistview.b;
import com.whatsapp.observablelistview.b.a;
import com.whatsapp.observablelistview.b.b;
import com.whatsapp.util.Log;

public class ConversationListView
  extends ListView
  implements b.a
{
  private b a;
  
  public ConversationListView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  @TargetApi(21)
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a();
  }
  
  private void a()
  {
    this.a = new b();
  }
  
  public final void a(b.b paramb)
  {
    this.a.a(paramb);
  }
  
  public void onInitializeAccessibilityNodeInfoForItem(View paramView, int paramInt, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    ListAdapter localListAdapter = getAdapter();
    if ((paramInt == -1) || (localListAdapter == null)) {
      return;
    }
    if (paramInt >= localListAdapter.getCount())
    {
      Log.w("conversationvistview/onInitializeAccessibilityNodeInfoForItem pos:" + paramInt + " count:" + localListAdapter.getCount());
      return;
    }
    super.onInitializeAccessibilityNodeInfoForItem(paramView, paramInt, paramAccessibilityNodeInfo);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.a();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.a.b();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    if (getTranscriptMode() == 2)
    {
      int j = View.MeasureSpec.getMode(paramInt2);
      int k = View.MeasureSpec.getSize(paramInt2);
      if (j != Integer.MIN_VALUE)
      {
        i = paramInt2;
        if (j != 1073741824) {}
      }
      else
      {
        i = paramInt2;
        if (k == 0) {
          i = View.MeasureSpec.makeMeasureSpec(1, j);
        }
      }
    }
    super.onMeasure(paramInt1, i);
  }
}


/* Location:              /home/chaitanya/sandbox/dex2jar-2.0/com.whatsapp-dex2jar.jar!/com/whatsapp/ConversationListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */