// Generated code from Butter Knife. Do not modify!
package com.sundevs.ihsan.newsapps.view.fragement;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.sundevs.ihsan.newsapps.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HealthFragment_ViewBinding implements Unbinder {
  private HealthFragment target;

  @UiThread
  public HealthFragment_ViewBinding(HealthFragment target, View source) {
    this.target = target;

    target.rvNews = Utils.findRequiredViewAsType(source, R.id.rv_news, "field 'rvNews'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HealthFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.rvNews = null;
  }
}
