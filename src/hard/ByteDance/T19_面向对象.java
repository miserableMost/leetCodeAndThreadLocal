package hard.ByteDance;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 李聪
 * @date 2020/4/5 22:58
 *  产品经理(PM)有很多好的idea，而这些idea需要程序员实现。现在有N个PM，在某个时间会想出一个 idea，每个 idea 有提出时间、所需时间和优先等级。对于一个PM来说，最想实现的idea首先考虑优先等级高的，相同的情况下优先所需时间最小的，还相同的情况下选择最早想出的，没有 PM 会在同一时刻提出两个 idea。
 *
 * 同时有M个程序员，每个程序员空闲的时候就会查看每个PM尚未执行并且最想完成的一个idea,然后从中挑选出所需时间最小的一个idea独立实现，如果所需时间相同则选择PM序号最小的。直到完成了idea才会重复上述操作。如果有多个同时处于空闲状态的程序员，那么他们会依次进行查看idea的操作。
 *
 * 求每个idea实现的时间。
 *
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。输出P行，分别表示每个idea实现的时间点。
 * 输入描述:
 *
 * 输入第一行三个数N、M、P，分别表示有N个PM，M个程序员，P个idea。随后有P行，每行有4个数字，分别是PM序号、提出时间、优先等级和所需时间。全部数据范围 [1, 3000]。
 */
public class T19_面向对象 {


    public static void main( String[] args ) {
        Scanner sc = new Scanner( System.in );
        int n = sc.nextInt(), m = sc.nextInt(), p = sc.nextInt();
        Idea[] ideas = new Idea[p];
        Thinker[] thinkers = new Thinker[n];
        Implementor[] implementors = new Implementor[m];
        for( int i = 0; i < m; i ++ )
            impleQueue.push( implementors[i] = new Implementor() );
        for( int i = 0; i < n; i ++ )
            thinkers[i] = new Thinker( i );
        for( int i = 0; i < p; i ++ ) {
            int pm = sc.nextInt()-1;
            int time = sc.nextInt();
            int prio = sc.nextInt();
            int cost = sc.nextInt();
            ideas[i] = new Idea( time, prio, cost );
            events.offer( thinkers[pm].getIdea( ideas[i] ) );
        }
        while( !events.isEmpty() ) {
            int time = events.peek().time;
            do { events.poll().occur();
            } while( !events.isEmpty() && events.peek().time == time );
            while( !impleQueue.isEmpty() && !thinkerQueue.isEmpty() ) {
                Thinker tmp1 = thinkerQueue.poll();
                Implementor tmp2 = impleQueue.pop();
                Idea tmp3 = tmp1.ideaQueue.poll();
                tmp3.finish = time + tmp3.cost;
                events.offer( tmp2.peekIdea( tmp3 ) );
                if( !tmp1.ideaQueue.isEmpty() ) thinkerQueue.offer( tmp1 );
            }
        }
        for( int i = 0; i < p; i ++ )
            System.out.println( ideas[i].finish );
        sc.close();
    }
    static PriorityQueue<Thinker> thinkerQueue = new PriorityQueue<>(
            (Thinker t1,Thinker t2) -> {
                int c1 = t1.ideaQueue.peek().cost;
                int c2 = t2.ideaQueue.peek().cost;
                return c1 == c2 ? t1.order - t2.order : c1 - c2;
            }
    );
    static ArrayDeque<Implementor> impleQueue = new ArrayDeque<>();
    static PriorityQueue<Event> events =
            new PriorityQueue<>( (Event e1,Event e2) -> e1.time - e2.time );
    static class Idea {
        int time, prio, cost, finish;
        Idea( int t, int p, int c ) { time = t; prio = p; cost = c; }
    }
    static class Thinker {
        PriorityQueue<Idea> ideaQueue = new PriorityQueue<>(
                (Idea i1,Idea i2) -> {
                    if( i1.prio != i2.prio ) return i2.prio - i1.prio;
                    else if( i1.cost != i2.cost ) return i1.cost - i2.cost;
                    else return i1.time - i2.time;
                }
        );
        int order;
        Thinker( int o ) { order = o; }
        IdeaEvent getIdea( Idea idea ) {
            return new IdeaEvent( this, idea );
        }
    }
    static class Implementor {
        FinishEvent peekIdea( Idea idea ) {
            return new FinishEvent( this, idea );
        }
    }
    static abstract class Event {
        int time;
        Event( int t ) { time = t; }
        abstract void occur();
    }
    static class IdeaEvent extends Event {
        Thinker thinker;
        Idea idea;
        IdeaEvent( Thinker t, Idea i ) {
            super( i.time );
            thinker = t; idea = i;
        }
        void occur() {
            thinkerQueue.remove( thinker );
            thinker.ideaQueue.offer( idea );
            thinkerQueue.offer( thinker );
        }
    }
    static class FinishEvent extends Event {
        Implementor implementor;
        Idea idea;
        FinishEvent( Implementor imple, Idea i ) {
            super( i.finish );
            implementor = imple; idea = i;
        }
        void occur() {
            impleQueue.push( implementor );
        }
    }
}
