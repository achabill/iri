package com.iota.iri.service.tipselection;

import java.util.Map;

import com.iota.iri.model.Hash;

/**
 * Walks the tangle from an entry point towards tips
 *
 */

public interface Walker {

    /**
     * Walk algorithm
     * <p>
     * Starts from a given {@code entryPoint} to select valid transactions to be used
     * as tips. Returns a valid transaction as a tip.
     * </p>
     *
     * @param entryPoint  Transaction hash to start walk from.
     * @param ratings  Map of ratings for each transaction that references entryPoint.
     * @param walkValidator Used to validate consistency of tails.
     * @return  Transaction hash of tip.
     * @throws Exception If DB fails to retrieve transactions
     */
    Hash walk(Hash entryPoint, Map<Hash, Integer> ratings, WalkValidator walkValidator) throws Exception;

}
