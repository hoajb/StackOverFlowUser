package it.hoanguyenminh.stackoverflowuser.customview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import it.hoanguyenminh.stackoverflowuser.R;

public class LoadingDialog extends android.support.v7.app.AlertDialog {
    private TextView txtMessage;

    protected LoadingDialog(@NonNull Context context) {
        super(context);
        setupView();
    }

    protected LoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        setupView();
    }

    protected LoadingDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        setupView();
    }

    public static LoadingDialog create(Context context) {
        return new LoadingDialog(context, R.style.MyProgressDialogTheme);
    }

    private void setupView() {
        View view = getLayoutInflater().inflate(R.layout.dialog_loading, null);
        setView(view);
        txtMessage = view.findViewById(R.id.msg);
//        ProgressBar progressBar = view.findViewById(R.id.progressBar);

    }

    public void setMessage(String msg) {
        if (TextUtils.isEmpty(msg)) {
            txtMessage.setVisibility(View.GONE);
        } else {
            txtMessage.setVisibility(View.VISIBLE);
            txtMessage.setText(msg);
        }
    }
}
