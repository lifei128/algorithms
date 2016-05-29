package com.lifeibigdata.algorithms.linearlist;

/**
 * Created by lifei on 16/5/26.
 */
/**
 * 题目：给定一个单向链表的头结点head,以及两个整数from和to
 * ,在单项链表上把第from个节点和第to个节点这一部分进行反转
 * 列如：
 * 1->2->3->4->5->null,from=2,to=4
 * 结果：1->4->3->2->5->null
 * 列如：
 * 1->2->3->null from=1,to=3
 * 结果为3->2->1->null
 *
 * 要求
 * 1、如果链表长度为N，时间复杂度要求为O（N),额外空间复杂度要求为O（1）
 * 2、如果不满足1<=from<=to<=N,则不调整
 *
 * 思路：先判断是否满足1<=from<=to<=N
 * 先找到from-1个节点fPre,和to+1个节点tPos,fPre,tPos分别是反转的前一个节点和后 一个节点，反准部分反转后
 * 然后连接fPre和tPos,如果fPre为null,则说明反转部分包含头结点，则返回新的头结点，也就是没反转之前反转部分
 * 的最后一个节点，如果fPre不为null,子返回旧的头结点
 *
 * 见leetcode ReverseLinkedListII
 *
 */
public class ReversePart {

}
