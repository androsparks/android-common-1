package org.solovyev.android.keyboard;

import org.jetbrains.annotations.NotNull;

/**
 * User: serso
 * Date: 11/1/12
 * Time: 9:32 PM
 */
public class AKeyboardControllerStateImpl<K extends AKeyboardDef> implements AKeyboardControllerState<K> {

    private boolean shifted;

	private boolean capsLock;

	private boolean completion;

    private boolean prediction;

	@NotNull
	private AKeyboard<? extends K> keyboard;

    private AKeyboardControllerStateImpl() {
    }

    @NotNull
    public static <K extends AKeyboardDef> AKeyboardControllerState<K> newDefaultState(@NotNull AKeyboard<? extends K> keyboard) {
        final AKeyboardControllerStateImpl<K> result = new AKeyboardControllerStateImpl<K>();

        result.shifted = false;
        result.capsLock = false;
        result.completion = false;
        result.prediction = false;
        result.keyboard = keyboard;

        return result;
    }

    @NotNull
    public static <K extends AKeyboardDef> AKeyboardControllerState<K> newInstance(boolean prediction, boolean completion, @NotNull AKeyboard<? extends K> keyboard) {
        final AKeyboardControllerStateImpl<K> result = new AKeyboardControllerStateImpl<K>();

        result.shifted = false;
        result.capsLock = false;
        result.completion = completion;
        result.prediction = prediction;
        result.keyboard = keyboard;

        return result;
    }

    @Override
    public boolean isShifted() {
        return shifted;
    }

    @Override
    public boolean isCapsLock() {
        return capsLock;
    }

    @Override
    public boolean isCompletion() {
        return completion;
    }

    @Override
    public boolean isPrediction() {
        return prediction;
    }

	@Override
	@NotNull
	public AKeyboard<? extends K> getKeyboard() {
		return keyboard;
	}

	@NotNull
	@Override
	public AKeyboardControllerState<K> copyForNewKeyboard(@NotNull AKeyboard<? extends K> keyboard) {
		final AKeyboardControllerStateImpl<K> result = new AKeyboardControllerStateImpl<K>();
		result.capsLock = this.capsLock;
		result.prediction = this.prediction;
		result.shifted = this.shifted;
		result.completion = this.completion;
		result.keyboard = keyboard;
		return result;
	}

	@NotNull
	@Override
	public AKeyboardControllerState<K> copyForNewCapsLock(boolean capsLock) {
		final AKeyboardControllerStateImpl<K> result = new AKeyboardControllerStateImpl<K>();
		result.capsLock = capsLock;
		result.prediction = this.prediction;
		result.shifted = this.shifted;
		result.completion = this.completion;
		result.keyboard = this.keyboard;
		return result;
	}
}
