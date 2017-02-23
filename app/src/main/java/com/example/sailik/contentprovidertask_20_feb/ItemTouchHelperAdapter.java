package com.example.sailik.contentprovidertask_20_feb;

/**
 * Created by saili.k on 22-02-2017.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
