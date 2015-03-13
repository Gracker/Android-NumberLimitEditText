package com.gracker.numberlimitedittext;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.Toast;

/**
 * NumberLimitEditText : An EditText with length limite
 * <ul>
 * <li>{@link #NumberLimitEditText(Context context)}</li>
 * <li>{@link #NumberLimitEditText(Context context, AttributeSet attrs)}</li>
 * <li>
 * {@link #NumberLimitEditText(Context context, AttributeSet attrs, int defStyle)}
 * </li>
 * <li>{@link #onPreDraw()}</li>
 * <li>{@link #getTextCount()}</li>
 * <li>{@link #setTextCount(int mTextCount)}</li>
 * <li>{@link #getToastLog()}</li>
 * <li>{@link #setToastLog(String mToastLog)}</li>
 * </ul>
 * <ul>
 * 
 * * @author <a href="http://www.androidperformance.com" target="_blank">Gracker</a>
 * 2014-4-28
 */

public class NumberLimitEditText extends EditText {
    public static String TAG = "NumberLimitEditText";

    public static int DEFAULT_TEXT_LIMIT_COUNT = 256;
    public static String DEFAULT_LIMIT_TEXT = "Word reached the maximum length";

    /**
     * Iindicates the context.
     */
    private Context mContext;

    /**
     * The text shown after text size out of limit.
     */
    private String mToastLog;

    /**
     * The limit count of input text
     */
    private int mTextCount;

    public NumberLimitEditText(Context context) {
        this(context, null);
    }

    public NumberLimitEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NumberLimitEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        mContext = context;
        mTextCount = DEFAULT_TEXT_LIMIT_COUNT;
        mToastLog = DEFAULT_LIMIT_TEXT;
    }

    @Override
    public boolean onPreDraw() {
        // TODO Auto-generated method stub

        if (getText().length() > mTextCount) {
            setText(getText().subSequence(0, mTextCount));
            setSelection(mTextCount);
            Toast.makeText(mContext, mToastLog, Toast.LENGTH_SHORT).show();
        }
        return super.onPreDraw();
    }

    /**
     * @return the mTextCount
     */
    public int getTextCount() {
        return mTextCount;
    }

    /**
     * @param mTextCount
     *            the mTextCount to set
     */
    public void setTextCount(int mTextCount) {
        this.mTextCount = mTextCount;
    }

    /**
     * @return the mToastLog
     */
    public String getToastLog() {
        return mToastLog;
    }

    /**
     * @param mToastLog the mToastLog to set
     */
    public void setToastLog(String mToastLog) {
        this.mToastLog = mToastLog;
    }
}
