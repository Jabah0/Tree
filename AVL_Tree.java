public class AVL_Tree {
    Node root;
    AVL_Tree()
    {
        this.root=null;
    }
    AVL_Tree(int data)
    {
        this.root=new Node(data);
    }
    private int max(int x,int y)
    {
        if(x>=y)
            return x;
        else
            return y;
    }
    private int get_hight(Node p)
    {
        if(p==null)
            return 0;
        else
            return 1+max(get_hight(p.right),get_hight(p.left));
            
    }
    private Node right_rotate(Node p)
    {
        Node x = p.left;
        Node z = x.right;
        p.left = z;
        x.right = p;
        return x;
    }
    private Node left_rotate(Node p)
    {
        Node x = p.right;
        Node z = p.left;
        p.right =z;
        x.left = p;
        return x;
    }
    private Node insert(Node temp ,int item)
    {
      if(temp==null)
             return new Node(item);
      if(item<=temp.data)
            temp.left = insert(temp.left,item);
      else
           temp.right = insert(temp.right,item);
    int blance = get_blance(temp);  
    if(blance >1 && item < temp.left.data)
        return right_rotate(temp);
    if(blance<-1 && item>temp.right.data)
        return left_rotate(temp);
    if(blance>1 && item>temp.left.data)
    {
        temp.left=left_rotate(temp.left);
        return right_rotate(temp);
    }
    if(blance<-1 && item<temp.right.data)
    {
        temp.right = right_rotate(temp.right);
        return left_rotate(temp);
    }
    return temp;
    }
    public void insert(int item)
    {
       if(this.root==null)
           this.root=new Node(item);
       else
       {
         insert(this.root,item);
       }
    }
    public int get_blance(Node p)
    {
        return get_hight(p.left) - get_hight(p.right);
    }
    private Node delete(Node p,int data)
    {
        if(p == null)
            return p;
        if(data<p.data)
            p.left=delete(p.left,data);
        else if(data>p.data)
            p.right=delete(p.right,data);
        else
        {
            if(p.right==null)
                return p.left;
            else if(p.left==null)
                return p.right;
            else
            {
                int x=get_max(p.left);
                p.data=x;
                delete(p.left,x);
                
            }
        }
        int blance = get_blance(p);
        if(blance>1 && get_blance(p.left)>=0)
            return right_rotate(p);
        if(blance>1 && get_blance(p.left)<0)
        {
            p.left=left_rotate(p.left);
            return right_rotate(p);
        }
        if(blance<-1 && get_blance(p.right)<=0)
            return left_rotate(p);
        if(blance<-1 && get_blance(p.right)>0)
        {
            p.right = right_rotate(p.right);
            return left_rotate(p);
        }
            return p;
    }
    public void delete(int data)
    {
        delete(this.root,data);
    }
        private int get_max(Node p)
    {
        if(p.right==null)
            return p.data;
        else
            return get_max(p.right);
    }
   public void in_order()
    {
        in_order(root);
    }
   private void in_order(Node temp)
    {
        if(temp!=null)
        {
            in_order(temp.left);
            System.out.print(temp.data +" ");
            in_order(temp.right);
        }
    }
}
