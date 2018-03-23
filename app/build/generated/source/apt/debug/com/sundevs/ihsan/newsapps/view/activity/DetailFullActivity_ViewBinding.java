// Generated code from Butter Knife. Do not modify!
package com.sundevs.ihsan.newsapps.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.webkit.WebView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sundevs.ihsan.newsapps.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailFullActivity_ViewBinding implements Unbinder {
  private DetailFullActivity target;

  private View view2131230800;

  @UiThread
  public DetailFullActivity_ViewBinding(DetailFullActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailFullActivity_ViewBinding(final DetailFullActivity target, View source) {
    this.target = target;

    View view;
    target.webView = Utils.findRequiredViewAsType(source, R.id.webview, "field 'webView'", WebView.class);
    view = Utils.findRequiredView(source, R.id.ic_menu, "method 'back'");
    view2131230800 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailFullActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.webView = null;

    view2131230800.setOnClickListener(null);
    view2131230800 = null;
  }
}
