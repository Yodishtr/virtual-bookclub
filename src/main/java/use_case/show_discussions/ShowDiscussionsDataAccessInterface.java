package use_case.show_discussions;

import java.util.List;

/**
 * DAO for show discussions usecase.
 */

public interface ShowDiscussionsDataAccessInterface {
    /**
     * Gets the topics of the discussions in the current club.
     * @return list of topic names
     */
    List<String> getDiscussionsTopics();

}
