package use_case.show_discussions;

/**
 * Output boundary for show discussions usecase.
 */
public interface ShowDiscussionsOutputBoundary {

    /**
     * Prepares the success view for the show discussions usecase.
     * @param outputData the output data
     */
    void prepareSuccessView(ShowDiscussionsOutputData outputData);

    /**
     * Prepares the fail view for the show discussions usecase.
     * @param errorMessage the message that will be displayed
     */
    void prepareFailView(String errorMessage);

    /**
     * Switches to add messsage view.
     * @param discussion the discussion that user chose to view messages for
     */
    void switchToAddMessageView(String discussion);
}
