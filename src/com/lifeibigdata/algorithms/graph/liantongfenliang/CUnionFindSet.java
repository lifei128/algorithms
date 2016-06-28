package com.lifeibigdata.algorithms.graph.liantongfenliang;

/**
 * Created by leofei.li on 2016/5/21.
 *
 * 并查集
 */
public class CUnionFindSet {
    static int m_mN;
    static int []m_pParent;

    void Union(int i,int j){
        if(i < 0 || i >= m_mN || j < 0 || j> m_mN){
            return;
        }
        int ri = Find(i);
        int rj = Find(j);
        if(ri != rj){
            m_pParent[ri] = rj;
        }
    }

    int Find(int i){
        if(i < 0 || i > m_mN){
            return -1;
        }
        int root = i;
        while(root != m_pParent[root]){
            root = m_pParent[root];
        }
        //ѹ��
        int t = i;
        int p;
        while (t != root){
            p = m_pParent[t];
            m_pParent[t] = root;
            t = p;
        }
        return root;
    }

    public CUnionFindSet(int n) {//�Լ������Լ��ĸ��ڵ�
        m_mN = n;
        m_pParent = new int[m_mN];
        for (int i = 0; i < m_mN; i++){
            m_pParent[i] = i;
        }
    }


    public static void main(String[] args) {
        int N = 10;
        CUnionFindSet ufs = new CUnionFindSet(N);
        ufs.Union(2,6);
        ufs.Union(5,6);
        ufs.Union(1,8);
        ufs.Union(2,9);
        ufs.Union(5,3);
        ufs.Union(4,8);
        ufs.Union(4,0);

        int []component = new int[N];
        for (int i = 0; i < N; i++){
            component[ufs.Find(i)]++;
        }
        int nComponent = 0;
        for (int i = 0; i < N; i++){
            if(component[i] != 0){
                nComponent++;
            }
        }
        System.out.println(nComponent);
    }
}
