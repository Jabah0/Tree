public class Binary_search_tree {
    Node root;
   Binary_search_tree(int data)
    {
       this.root=new Node(data);
        
    }
   Binary_search_tree()
   {
       this.root=null;
   }
    private void insert(Node temp ,int item)
    {
      if(temp==null)
          this.root=new Node(item);
      else if(item<=temp.data)
      {
          if(temp.left==null)
              temp.left=new Node(item);
          else
              insert(temp.left,item);
      }
      else
      {
       if(temp.right==null)
           temp.right=new Node(item);
       else
           insert(temp.right,item);
      }
          
    }
    public void insert(int item)
    {
      insert(root,item); 
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
    public void in_order()
    {
        in_order(root);
    }
    private Node delete(Node p,int item)
    {
        if(item<p.data)
           p.left=delete(p.left,item);
        else if(item>p.data)
            p.right=delete(p.right,item);
        else
        {
            if(p.right==null)
                return p.left;
            else if(p.left==null)
               return p.right;
            else
            {
               p.data=get_max(p.left);
               delete(p.left,p.data);
            }
        }
        return p;
    }
    public void delete(int item)
    {
       delete(root,item); 
    }
    private int get_max(Node p)
    {
        if(p.right==null)
            return p.data;
        else
            return get_max(p.right);
    }
    public int get_max()
    {
        return get_max(root);
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
    public int get_hight()
    {
       return get_hight(root);
    }
    private int Node_count(Node p)
    {
        if(p==null)
            return 0;
        else
            return 1+Node_count(p.right)+Node_count(p.left);
    }
    public int Node_count()
    {
        return Node_count(root);
    }
    private int leave_count(Node p)
    {
       if(p==null)
           return 0; 
       else if(p.right==null && p.left==null)
            return 1;
        else
           return leave_count(p.right)+leave_count(p.left);
    }
    public int leave_count()
    {
        return leave_count(root);
    }
    private boolean search(Node p,int item)
    {
        if(p==null)
            return false;
        else if(p.data==item)
            return true;
        else if(p.data<item)
            return search(p.right,item);
        else
            return search(p.left,item);
    }
    public boolean search(int item)
    {
        return search(root,item);
    }
}
