import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolExampleFibonacci extends RecursiveTask<Integer> {
	int num;

	public ForkJoinPoolExampleFibonacci(int num) {
		this.num = num;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		if (num <= 1)
			return num;
		ForkJoinPoolExampleFibonacci num_1 = new ForkJoinPoolExampleFibonacci(num - 1);
		ForkJoinPoolExampleFibonacci num_2 = new ForkJoinPoolExampleFibonacci(num - 2);

		num_1.fork();
		num_2.fork();
		int num_1res = num_1.join();
		int num_2res = num_2.join();
		return num_1res + num_2res;
	}

}

class ForkJoinPoolSumComputeTask extends RecursiveTask<Integer> {
	int start;
	int end;

	public ForkJoinPoolSumComputeTask(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Integer compute() {
		// TODO Auto-generated method stub
		if (end - start <= 4) {
			int sum = 0;
			for (int i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		}
		int mid = (start + end) / 2;
		ForkJoinPoolSumComputeTask left = new ForkJoinPoolSumComputeTask(start, mid);
		ForkJoinPoolSumComputeTask right = new ForkJoinPoolSumComputeTask(mid + 1, end);

		left.fork();
		right.fork();

		return left.join() + right.join();

	}

}

class ForkJoinPoolExampleMain {
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
		System.out.println("available processors=" + Runtime.getRuntime().availableProcessors());
		Future<Integer> future = forkJoinPool.submit(new ForkJoinPoolExampleFibonacci(4));
		int ans;
		try {
			ans = future.get();
			System.out.println("ans=" + ans);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forkJoinPool.shutdown();
		
		  ForkJoinPool pool= ForkJoinPool.commonPool(); 
		 Future<Integer> futureObj=pool.submit(new ForkJoinPoolSumComputeTask(0,10));
		 try {
			int sum=futureObj.get();
			System.out.println("sum="+sum);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	ExecutorService service=	Executors.newWorkStealingPool();
	ForkJoinPool pool1= (ForkJoinPool)service;
	Future<Integer> fiboans=pool.submit(new ForkJoinPoolExampleFibonacci(10));
	try {
		int ansFib=fiboans.get();
		System.out.println("ans of Executors.newWorkStealingPool();="+ansFib);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ExecutionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		 
	}
}
