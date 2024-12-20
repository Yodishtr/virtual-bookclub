package interface_adapter.show_discussions;

import interface_adapter.ViewManagerModel;
import interface_adapter.add_message.AddMessageState;
import interface_adapter.add_message.AddMessageViewModel;
import use_case.show_discussions.ShowDiscussionsOutputBoundary;
import use_case.show_discussions.ShowDiscussionsOutputData;

/**
 * The presenter for the show topics usecase.
 */
public class ShowDiscussionsPresenter implements ShowDiscussionsOutputBoundary {

    private final ShowDiscussionsViewModel showTopicsViewModel;
    private final AddMessageViewModel addMessageViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShowDiscussionsPresenter(ShowDiscussionsViewModel showTopicsViewModel,
                                    ViewManagerModel viewManagerModel, AddMessageViewModel addMessageViewModel) {
        this.showTopicsViewModel = showTopicsViewModel;
        this.viewManagerModel = viewManagerModel;
        this.addMessageViewModel = addMessageViewModel;
    }

    @Override
    public void prepareSuccessView(ShowDiscussionsOutputData outputData) {
        final ShowDiscussionsState state = showTopicsViewModel.getState();
        state.setTopics(outputData.getTopics());
        showTopicsViewModel.firePropertyChanged("topics");
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final ShowDiscussionsState state = showTopicsViewModel.getState();
        state.setErrorMessage(errorMessage);
        showTopicsViewModel.firePropertyChanged("error");
    }

    @Override
    public void switchToAddMessageView(String discussion) {
        final AddMessageState state = addMessageViewModel.getState();
        state.setCurrentDiscussion(discussion);
        addMessageViewModel.firePropertyChanged();

        viewManagerModel.setState(addMessageViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

}
