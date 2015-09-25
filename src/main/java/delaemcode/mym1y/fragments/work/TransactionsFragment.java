package delaemcode.mym1y.fragments.work;

import android.database.Cursor;
import android.view.View;
import android.widget.ListView;

import delaemcode.mym1y.R;
import delaemcode.mym1y.adapters.TransactionsCursorAdapter;
import delaemcode.mym1y.database.Contract;
import delaemcode.mym1y.database.DBHelper;

public class TransactionsFragment
        extends WorkFragment
{
    public interface ITransactionClick
            extends IMyMyFragmentClick
    {
    }

    ListView transactionslist;

    TransactionsCursorAdapter transactionsCursorAdapter;

    public TransactionsFragment()
    {
        super(R.layout.transactions);
    }

    @Override
    protected void findViews(View v)
    {
        super.findViews(v);
        //
        transactionslist = (ListView) v.findViewById(R.id.transactionslist);
        Cursor data = DBHelper.getInstance(getActivity()).query(Contract.getContract(Contract.TABLE_NAME_TRANSACTION), null, null, null, null);
        transactionsCursorAdapter = new TransactionsCursorAdapter(getActivity(), data);
        transactionslist.setAdapter(transactionsCursorAdapter);
        transactionsCursorAdapter.notifyDataSetChanged();
    }
}