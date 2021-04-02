package indi.zhifa.learn.common.response.enums;

/**
 * @author 芝法酱
 */

public enum Series {
    INFORMATIONAL(1),
    SUCCESSFUL(2),
    REDIRECTION(3),
    CLIENT_ERROR(4),
    SERVER_ERROR(5);

    private final int value;

    Series(int value) {
        this.value = value;
    }

    /**
     * Return the integer value of this status series. Ranges from 1 to 5.
     */
    public int value() {
        return this.value;
    }

    /**
     * Return the {@code Series} enum constant for the supplied {@code HttpStatus}.
     *
     * @param status a standard HTTP status enum constant
     * @return the {@code Series} enum constant for the supplied {@code HttpStatus}
     * @deprecated as of 5.3, in favor of invoking {@link HttpStatus#series()} directly
     */
    @Deprecated
    public static Series valueOf(HttpStatus status) {
        return status.series();
    }

    /**
     * Return the {@code Series} enum constant for the supplied status code.
     *
     * @param statusCode the HTTP status code (potentially non-standard)
     * @return the {@code Series} enum constant for the supplied status code
     * @throws IllegalArgumentException if this enum has no corresponding constant
     */
    public static Series valueOf(int statusCode) {
        Series series = resolve(statusCode);
        if (series == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        }
        return series;
    }

    /**
     * Resolve the given status code to an {@code HttpStatus.Series}, if possible.
     *
     * @param statusCode the HTTP status code (potentially non-standard)
     * @return the corresponding {@code Series}, or {@code null} if not found
     * @since 5.1.3
     */
    public static Series resolve(int statusCode) {
        int seriesCode = statusCode / 100;
        for (Series series : values()) {
            if (series.value == seriesCode) {
                return series;
            }
        }
        return null;
    }
}
