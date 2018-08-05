package priority_queue.exercises.exercise_6;

/**
 * Is a heap a full or complete binary tree?
 * It is a complete binary tree.
 * In level < l - 1:
 *  - Nodes must have 2 children
 * In level == l - 1:
 *  - If my left sibling has 2 children, I might have 2 children, 1 left child or 0 children.
 *  - If my left sibling has 1 child, I can not have any children.
 *  - If my left sibling has 0 children, I can not have any children.
 * In level == l:
 *  - Nodes can not have any children
 *
 * It is not a full binary tree, because it would allow for nodes in levels < l - 1 to have 0 children.
 */
public class Solution {
}
