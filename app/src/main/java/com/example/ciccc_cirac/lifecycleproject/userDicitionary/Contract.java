package com.example.ciccc_cirac.lifecycleproject.userDicitionary;

import android.net.Uri;

/**
 * Created by saeko on 8/18/2017.
 */

public final class Contract {
    private Contract(){

    }
    // In the Contract class, create a constant for AUTHORITY.
    // To make Authority unique, use the package name extended with "provider."
    public static final String AUTHORITY = "com.numetriclabz.userdictionary.provider";

    //Create a constant for the CONTENT_PATH. The content path identifies the data.
    //for example, the name of a table or file, or the kind of data, such as "words"

    public static final String CONTENT_PATH = "words";

    //Create a constant for the CONTENT_URI. This is a content:// style URI that points to one set of data.
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + CONTENT_PATH);

    //Create a convenience constant for ALL_ITEMS.
    // This is the dataset name you will use when retrieving all the words.
    // The value is -2 because that's the first lowest value not returned by a method call.
    static final int ALL_ITEMS = -2;
    //Create a  constant for WORD_ID.
    // This is the id you will use when retrieving a single word.
    static final String WORD_ID = "id";
    static final String MULTIPLE_RECORD_MIME_TYPE = "vnd.android.cursor.dir/vnd.com.example.provider.words";
    static final String SINGLE_RECORD_MIME_TYPE = "vnd.android.cursor.item/vnd.com.example.provider.words";


}