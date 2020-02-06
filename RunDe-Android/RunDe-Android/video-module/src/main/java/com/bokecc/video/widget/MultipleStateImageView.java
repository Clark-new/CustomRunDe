package com.bokecc.video.widget;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import java.util.HashMap;
import java.util.Map;

public class MultipleStateImageView extends AppCompatImageView {

    public interface SelectState {
    }

    private Map<SelectState, Integer> stateMap;

    private SelectState currentState;

    public MultipleStateImageView(Context context) {
        this(context, null);
    }

    public MultipleStateImageView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MultipleStateImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        stateMap = new HashMap<>();
    }

    public void addState(SelectState state,int res) {
        stateMap.put(state, res);
    }

    public void select(SelectState state) {
        Integer resId = stateMap.get(state);
        if (resId == null) return;
        setImageResource(resId);
        currentState = state;
    }

    public SelectState getState() {
        return currentState;
    }
}
