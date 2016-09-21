package com.lifeibigdata.algorithms.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lifei on 16/9/20.
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int N = 256;
        char[] str = "aabbbbbccdeffffghijklmnopqrstuvwxyz".toCharArray();
        int pWeight[] = new int[N];
        calcFrequency(str,pWeight);
//        pWeight['\t'] = 0;
        List<Integer> pChar = new ArrayList<>();
        calcExistChar(pWeight,N,pChar);
//        for (Integer c:pChar) {
//            System.out.println("---"+c);
//        }
//        for (int w:pWeight) {
//            System.out.println("==="+w);
//        }
        int N2 = pChar.size();
        List<List<Character>> code = new ArrayList<>();
        List<Character> c;
        for (int i = 0; i < N2; i++) {
            c = new ArrayList<>();
            code.add(c);
        }
        huffmanCoding(pWeight,N2,code);
        print(code,pChar);
    }

    private static void print(List<List<Character>> code, List<Integer> pChar) {
        for (int i = 0; i < code.size(); i++) {
            String s = "";
            for (Character c:code.get(i)) {
                s += c;
            }
            System.out.println(pChar.get(i)+"   "+((char)pChar.get(i).intValue())+"    "+s);
        }
    }

    private static void huffmanCoding(int[] pWeight, int N, List<List<Character>> code) {
        if (N <= 0)
            return;
        int m = 2 * N - 1;
        HuffmanNode[] pHuffmanTree = new HuffmanNode[m];
        HuffmanNode huffmanNode;
        for (int i = 0; i < m; i++) {
            huffmanNode = new HuffmanNode();
            pHuffmanTree[i] = huffmanNode;
        }
        int s1 = 0,s2 = 0;
        for (int i = 0; i < N; i++) {
            pHuffmanTree[i].nWeight = pWeight[i];
        }
        //每次选择权值最小的两个节点,建树
        for (int i = N; i < m; i++) {
            int[] s1s2 = selectNode(pHuffmanTree,i,s1,s2);
            s1 = s1s2[0];
            s2 = s1s2[1];
            pHuffmanTree[s1].nParent = pHuffmanTree[s2].nParent = i;
            pHuffmanTree[i].nLeft = s1;
            pHuffmanTree[i].nRight = s2;
            pHuffmanTree[i].nWeight = pHuffmanTree[s1].nWeight + pHuffmanTree[s2].nWeight;
        }
        //根据建好的Huffman树从叶子到根计算每个叶节点的编码
        int node,nParent;
        for (int i = 0; i < N; i++) {
            List<Character> cur = code.get(i);
            node = i;
            nParent = pHuffmanTree[node].nParent;
            while (nParent != 0){
                if (pHuffmanTree[nParent].nLeft == node){
                    cur.add('0');
                } else {
                    cur.add('1');
                }
                node = nParent;
                nParent = pHuffmanTree[node].nParent;
            }
            Collections.reverse(cur);
        }
    }

    private static int[] selectNode(HuffmanNode[] pHuffmanTree, int n, int s1, int s2) {
        s1 = -1;//无效值
        s2 = -1;
        int nMin1 = -1;//无效值
        int nMin2 = -1;
        for (int i = 0; i < n; i++) {
            if (pHuffmanTree[i].nParent == 0 && pHuffmanTree[i].nWeight >0){
                if (s1 < 0 || nMin1 > pHuffmanTree[i].nWeight){
                    s2 = s1;
                    nMin2 = nMin1;
                    s1 = i;
                    nMin1 = pHuffmanTree[s1].nWeight;
                } else if (s2 < 0 || nMin2 > pHuffmanTree[i].nWeight){
//                    s1 = s2;
//                    nMin1 = nMin2;
                    s2 = i;
                    nMin2 = pHuffmanTree[s2].nWeight;
                }
            }
        }
//        System.out.println(s1+"###"+s2);
        return new int[]{s1,s2};
    }

    private static void calcExistChar(int[] pWeight, int n, List<Integer> pChar) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (pWeight[i] != 0){
                pChar.add(i);
                if (j != i){
                    pWeight[j] = pWeight[i];
                }
                j++;
            }
        }
    }

    private static void calcFrequency(char[] str, int[] pWeight) {
        for (char c:str) {
            pWeight[c] += 1;    //TODO
        }
    }

    static class HuffmanNode{
        int nParent;
        int nLeft;
        int nRight;
        int nWeight;
    }
}
