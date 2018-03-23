// Generated code from Butter Knife. Do not modify!
package com.sundevs.ihsan.newsapps.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.sundevs.ihsan.newsapps.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DetailNewsActivity_ViewBinding implements Unbinder {
  private DetailNewsActivity target;

  private View view2131230905;

  private View view2131230800;

  @UiThread
  public DetailNewsActivity_ViewBinding(DetailNewsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DetailNewsActivity_ViewBinding(final DetailNewsActivity target, View source) {
    this.target = target;

    View view;
    target.ivImgNews = Utils.findRequiredViewAsType(source, R.id.img_news, "field 'ivImgNews'", ImageView.class);
    target.tvTitleNews = Utils.findRequiredViewAsType(source, R.id.title_news, "field 'tvTitleNews'", TextView.class);
    target.tvContentNews = Utils.findRequiredViewAsType(source, R.id.content_news, "field 'tvContentNews'", TextView.class);
    target.tvAuthorNews = Utils.findRequiredViewAsType(source, R.id.author_news, "field 'tvAuthorNews'", TextView.class);
    target.tvDateNews = Utils.findRequiredViewAsType(source, R.id.date_news, "field 'tvDateNews'", TextView.class);
    view = Utils.findRequiredView(source, R.id.source_news, "field 'tvSourceNews' and method 'back'");
    target.tvSourceNews = Utils.castView(view, R.id.source_news, "field 'tvSourceNews'", TextView.class);
    view2131230905 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.ic_menu, "method 'back'");
    view2131230800 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.back(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    DetailNewsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.ivImgNews = null;
    target.tvTitleNews = null;
    target.tvContentNews = null;
    target.tvAuthorNews = null;
    target.tvDateNews = null;
    target.tvSourceNews = null;

    view2131230905.setOnClickListener(null);
    view2131230905 = null;
    view2131230800.setOnClickListener(null);
    view2131230800 = null;
  }
}
