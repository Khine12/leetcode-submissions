#include<iostream>

// Definition for singly-linked list.

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* L1, ListNode* L2) {
        // keep track of the head of the new list, and the tail to add on to
        ListNode dummy;   // Dummy node to simplify edge cases
        ListNode* tail = &dummy;

        // iterate until we reach the end of the list
        while (L1 != nullptr && L2 != nullptr )
        {
            // compare the heads of both lists 
            if(L1 -> val < L2 ->val)
            {
                tail->next = L1;
                L1 = L1-> next;
            }
            else
            {
                tail -> next = L2;
                L2 = L2 -> next;
            }
            tail = tail -> next;
        }
        tail->next = (L1 == nullptr) ? L2 : L1;

        return dummy.next;
    }
};
