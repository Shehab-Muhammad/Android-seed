# Android Seed project #

This code is a base for every android project with [MVP architecture](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93presenter)
we have used some libraries
- Support libraries
- RecyclerViews
- [Retrofit 2](http://square.github.io/retrofit/)
- [Dagger 2](http://google.github.io/dagger/)
- [Butterknife](https://github.com/JakeWharton/butterknife)
- [Glide](https://github.com/bumptech/glide)

### How to implement a new screen following MVP

Imagine you have to implement a sign in screen.

1. Create a new package under `ui` called `signin`
2. Create an new Activity called `ActivitySignIn`. You could also use a Fragment.
3. Define the view interface that your Activity is going to implement. Create a new interface called `SignInView` that extends `BaseView`. Add the methods that you think will be necessary, e.g. `showSignInSuccessful()`
4. Create a `SignInPresenter` class that extends `BasePresenter<SignInView>`
5. Implement the methods in `SignInPresenter` that your Activity requires to perform the necessary actions, e.g. `signIn(String email)`. Once the sign in action finishes you should call `getView().showSignInSuccessful()`.
6. Create a `SignInPresenterTest`and write unit tests for `signIn(email)`. Remember to mock the  `SignInView` and also the `DataManager`.
7. Make your  `ActivitySignIn` implement `SignInView` and implement the required methods like `showSignInSuccessful()`
8. In your activity, inject a new instance of `SignInPresenter` and call `presenter.attach(this)` from `onCreate` and `presenter.detach()` from `onDestroy()`. Also, set up a click listener in your button that calls `presenter.signIn(email)`.

## Event bus ##

when you want to emit an event from anywhere and subscribe to this event from any other place (ex. presenter):
1. create event class
```
class MyEvent{
    private String message;
    private Integer identifier;

    public MyEvent(Integer id, String msg){
        message = msg;
        identifier = id;
    }

    public String getMsg(){
        return message;
    }
}
```

2. subscribe this event anywhere
```
    // attach(View)
    // ...
    Consumer<MyEvent> consumer = new Consumer<MyEvent>() {

        @Override
        public void accept(MyEvent e) throws Exception {
            // your code go here
            Toast.makeText((Activity)getView(), e.getMsg(), Toast.LENGTH_LONG)
                    .show();
        }
    };
    busDisposable = bus.filteredObservable(String.class)
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe(consumer);
```

3. where you want to emit the event
```
    bus.post(password);
```

4. don't forget to despose
```
    busDisposable.dispose();
```