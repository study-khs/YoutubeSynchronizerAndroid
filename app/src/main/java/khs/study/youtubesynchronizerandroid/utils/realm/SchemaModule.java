package khs.study.youtubesynchronizerandroid.utils.realm;

import io.realm.annotations.RealmModule;
import khs.study.youtubesynchronizerandroid.models.player.db.SearchKeyword;

/**
 * Created by jaeyoung on 2017. 6. 17..
 */

@io.realm.annotations.RealmModule(classes = { SearchKeyword.class })
public class SchemaModule {
}
