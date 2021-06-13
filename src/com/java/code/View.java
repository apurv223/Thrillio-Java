package com.java.code;

import com.java.code.constants.KidFriendlyStatus;
import com.java.code.constants.UserType;
import com.java.code.controller.BookmarkController;
import com.java.code.entity.Bookmark;
import com.java.code.entity.User;
import com.java.code.partner.Shareable;

public class View {
    public static void browse(User user, Bookmark[][] bookmarks){
        System.out.println( "\nUser wiht email: "+user.getEmail() + " is browsing items...");
        int bookmarkCount = 0;
        for(Bookmark[] bookmarkList: bookmarks){
            for(Bookmark bookmark: bookmarkList){
                if(bookmarkCount<DataStore.MAX_BOOKMARKS_PER_USER){
                    boolean isBookmarked = getBookmarkDecision(bookmark);
                    bookmarkCount++;
                    BookmarkController.getInstance().saveUserBookmark(user, bookmark);
                    System.out.println("New item bookmarked: "+bookmark);
                }

                //mark as kid friendly
                if(user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)){
                    //Mark ked friendly status
                    if(bookmark.isKidFriendly() && bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)){
                        String kidFriendlyDecision = getKidFriendlyDecision(bookmark);
                        if(!kidFriendlyDecision.equals(KidFriendlyStatus.UNKNOWN)){
                            BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyDecision,bookmark );
                        }
                    }
                    //Share it
                    if(bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
                    && bookmark instanceof Shareable){
                       boolean isShared = getShareDecision();
                       if(isShared){
                           BookmarkController.getInstance().share(user, bookmark);
                       }
                    }
                }
            }
        }
    }

    private static boolean getShareDecision() {
        return Math.random() < 0.5;
    }

    private static String getKidFriendlyDecision(Bookmark bookmark) {
        return Math.random()<=0.4?KidFriendlyStatus.APPROVED:
                Math.random()<=0.8?KidFriendlyStatus.REJECTED:KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5;
    }
/*    public static void bookmark(User user, Bookmark[][] bookmarks){
        System.out.println( "\nUser wiht email: "+user.getEmail() + " is bookmarking");
        for(int i=0;i<DataStore.MAX_BOOKMARKS_PER_USER;i++){
            int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPE_NUMBER);
            int bookmarkOffset = (int) (Math.random() * DataStore.MAX_NUMBER_PER_BOOKMARK_TYPE);

            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);
            System.out.println(bookmark);
        }
    }*/
}
