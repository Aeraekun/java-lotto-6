package lotto.domain;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.constant.Number.*;
import static lotto.constant.message.ErrorMessage.*;

public class Lotto {
    private final List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validate(lotto);
        sortLotto(lotto);
        this.lotto = lotto;
    }

    private void validate(List<Integer> lotto) {
        isLengthSix(lotto);
        isDistinct(lotto);
        isInRange(lotto);
    }

    private void isLengthSix(List<Integer> lotto) throws IllegalArgumentException {
        if (lotto.size() != LOTTO_LENGTH) {
            System.out.println(IS_NOT_LENGTH_SIX);
            throw new IllegalArgumentException();
        }
    }

    private void isDistinct(List<Integer> lotto) throws IllegalArgumentException {
        Set<Integer> tempLotto = new HashSet<>(lotto);
        if (lotto.size() != tempLotto.size()) {
            System.out.println(IS_NOT_DISTINCT);
            throw new IllegalArgumentException();
        }
    }

    private void isInRange(List<Integer> lotto) throws IllegalArgumentException {
        for (Integer i : lotto) {
            if (i < MIN_NUMBER || i > MAX_NUMBER) {
                System.out.println(IS_NOT_IN_RANGE);
                throw new IllegalArgumentException();
            }
        }
    }

    private void sortLotto(List<Integer> lotto) {
        lotto.sort(Comparator.naturalOrder());
    }

    public String getLotto() {
        return toString();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    public List<Integer> getLottoNumber() {
        return lotto;
    }
}
