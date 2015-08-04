package com.kenpos.app.picture_books_pokemon_pro;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.SystemClock;


public class ProgressTask extends AsyncTask<Void,Integer,Boolean>{
    private Context mContext;
    private ProgressDialog mProgressDialog;
    private Boolean isShowProgress;

    /**
     * コンストラクタ
     * @param context
     */
    public ProgressTask(Context context){
        mContext = context;
    }

    /**
     * getIsShowProgress
     * プログレスダイアログが表示中かどうかを返します。
     * @return
     */
    public Boolean getIsShowProgress() {
        return isShowProgress;
    }

    /**
     * onPreExecute
     * 最初にUIスレッドで呼び出されます。
     * UIに関わる処理をします。
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        isShowProgress = true;
        showDialog();
    }

    /**
     * doInBackground
     * ワーカースレッド上で実行されます。
     * このメソッドに渡されるパラメータの型はAsyncTaskの一つ目のパラメータです。
     * このメソッドの戻り値は AsyncTaskの三つ目のパラメータです。
     * @return 
     */
    @Override
    protected Boolean doInBackground(Void... params) {
        for(int i=0; i<10; i++){
            SystemClock.sleep(1000);
            // キャンセルが押された場合                
            if (isCancelled()) {   
                return false;                
            }
            publishProgress((i+1) * 10);
        }
        return true;
    }

    /**
     * onProgressUpdate
     * doInBackground内でpublishProgressメソッドが呼ばれると、 UIスレッド上でこのメソッドが呼ばれます。 
     * このメソッドの引数の型はAsyncTaskの二つ目のパラメータです。 
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressDialog.setProgress(values[0]);  
    }

    /**
     * onPostExecute
     * doInBackground が終わるとそのメソッドの戻り値をパラメータとして渡して onPostExecute が呼ばれます。
     * このパラメータの型は AsyncTask を extends するときの三つめのパラメータです。
     * バックグラウンド処理が終了し、メインスレッドに反映させる処理をここに書きます。
     * @param result
     */
    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        dismissDialog();
        isShowProgress = false;
    }

    /**
     * onCancelled
     * cancelメソッドが呼ばれるとonCancelledメソッドが呼ばれます。
     */
    @Override
    protected void onCancelled() {
        super.onCancelled();
        dismissDialog();
        isShowProgress = false;
    }

    /**
     * showDialog
     * プログレスダイアログを表示します
     */
    public void showDialog() { 
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("データ読み込み中...");
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mProgressDialog.setIndeterminate(false);
        mProgressDialog.setMax(100);
        mProgressDialog.incrementProgressBy(0);
        mProgressDialog.setCancelable(true);
        mProgressDialog.setButton("キャンセル", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                cancel(true); // 非同期処理をキャンセルする
            } 
        });
        mProgressDialog.show();
    }

    /**
     * dismissDialog
     * ダイアログを終了する。
     */
    public void dismissDialog() {
        mProgressDialog.dismiss();
        mProgressDialog = null;
    }

}

