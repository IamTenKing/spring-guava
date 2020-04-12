package com.example.springlearn.guava.Collections.Utility;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * create by chenjiayang on 2018/9/16
 */
public class SetsTest {

    public static void main(String[] args) {
        Set<Character> first = ImmutableSet.of('a', 'b', 'c');
        Set<Character> second = ImmutableSet.of('b', 'c', 'e');

        /**
         * a union operation over Sets
         * 集合的合集
         */
        Set<Character> union = Sets.union(first, second);
//        System.out.println(Joiner.on(",").join(union));


        /**
         * 差集
         */
        Sets.SetView<Character> difference = Sets.difference(first, second);
        System.out.println("差异："+Joiner.on(",").join(difference));

        //交集
        Set<Character> intersection = Sets.intersection(first, second);
        System.out.println("交集:"+Joiner.on(",").join(intersection));


        /**
         * 对比list
         */

        ArrayList<String> list = Lists.newArrayList("a", "b", "c");
        ArrayList<String> list1 = Lists.newArrayList("c", "d", "e");

        //并集
        Set<String> union1 = Sets.union(Sets.newHashSet(list), Sets.newHashSet(list1));
        System.out.println("并集去重"+Joiner.on(",").join(union1));


        //交集
        Set<String> intersection1 = Sets.intersection(Sets.newHashSet(list), Sets.newHashSet(list1));
        System.out.println("交集:"+Joiner.on(",").join(intersection1));

        //差集
        Sets.SetView<String> difference1 = Sets.difference(Sets.newHashSet(list), Sets.newHashSet(list1));
        System.out.println("差集"+Joiner.on(",").join(difference1));


        //并集不去重
        Iterable<String> concat = Iterables.concat(list, list1);
        System.out.println("并集不去重："+Joiner.on(",").join(concat));

        //所有差集合并
        Sets.SetView<String> strings = Sets.symmetricDifference(Sets.newHashSet(list), Sets.newHashSet(list1));
        System.out.println("symmetricDifference:"+Joiner.on(",").join(strings));


        //返回集合的所有子集
        Set<Set<String>> sets = Sets.powerSet(Sets.newHashSet(list));
        Iterator<Set<String>> iterator = sets.iterator();
        while(iterator.hasNext()){
            Set<String> next = iterator.next();
            System.out.println("======"+Joiner.on(",").join(Sets.newHashSet(next)));
        }
    }
}
